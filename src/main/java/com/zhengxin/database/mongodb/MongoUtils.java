package com.zhengxin.database.mongodb;

import com.google.common.collect.Lists;
import com.mongodb.Block;
import com.mongodb.ReadPreference;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.*;
import com.mongodb.client.result.UpdateResult;

import org.apache.commons.lang.BooleanUtils;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MongoUtils {
	static final Logger logger = LoggerFactory.getLogger(MongoUtils.class);
	private static final String OP_SET = "$set";
	private static final String OP_UNSET = "$unset";
	public static final String MONGO_FIELD_UPDATE_DATE = "mongoUpdateTime";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> int partialUpdateByMorphia(T entity, String... updateFields) {
		Datastore datastore = MongoClients.getDatastore();
		Object id = MongoClients.getMorphia().getMapper().getId(entity);
		Class entityClass = entity.getClass();
		UpdateOperations updateOperations = datastore.createUpdateOperations(entityClass);
		for (String field : updateFields) {
			Object fieldVal = Reflects.invokeCachedGetter(entityClass, entity, field);
			if (null != fieldVal) {
				updateOperations.set(field, fieldVal);
			} else {
				updateOperations.unset(field);
			}
		}
		Query<T> query = datastore.createQuery(entityClass);
		query.field(Reflects.getCachedPkFieldName(entityClass)).equal(id);

		UpdateResults updateResults = datastore.updateFirst(query, updateOperations, true);

		int ret = updateResults.getUpdatedCount();
		if (0 == ret) {
			ret = null != updateResults.getWriteResult().getUpsertedId() ? 1 : 0;
		}
		return ret;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Deprecated
	public static <T> int partialUpdatesByMorphia(List<T> entities, String... updateFields) {
		if (CollectionUtils.isEmpty(entities)) {
			return 0;
		}
		Datastore datastore = MongoClients.getDatastore();
		Class entityClass = entities.get(0).getClass();
		int ret = 0;
		for (T entity : entities) {
			if (null == entity) {
				continue;
			}
			Object id = MongoClients.getMorphia().getMapper().getId(entity);
			UpdateOperations updateOperations = datastore.createUpdateOperations(entityClass);
			for (String field : updateFields) {
				Object fieldVal = Reflects.invokeCachedGetter(entityClass, entity, field);
				if (null != fieldVal) {
					updateOperations.set(field, fieldVal);
				} else {
					updateOperations.unset(field);
				}
			}
			Query<T> query = datastore.createQuery(entityClass);
			query.field(Reflects.getCachedPkFieldName(entityClass)).equal(id);

			UpdateResults updateResults = datastore.updateFirst(query, updateOperations, true);

			int tmp = updateResults.getUpdatedCount() + updateResults.getInsertedCount();
			ret += tmp;
		}
		return ret;
	}

	public static <T> int partialUpdateByMongo(String collectionName, T entity, String... updateFields) {
		MongoCollection<Document> collection = MongoClients.getCollection(collectionName, true);
		Class<?> entityClass = entity.getClass();
		Object id = Reflects.invokeCachedGetter(entityClass, entity, Reflects.getCachedPkFieldName(entityClass));
		List<Bson> updates = Lists.newArrayList(Updates.set(MONGO_FIELD_UPDATE_DATE, new Date()));
		for (String field : updateFields) {
			Object fieldVal = Reflects.invokeCachedGetter(entityClass, entity, field);
			if (null != fieldVal) {
				updates.add(Updates.set(field, fieldVal));
			} else {
				updates.add(Updates.unset(field));
			}
		}
		UpdateResult updateResults = collection.updateOne(Filters.eq(MongoClients.MONGOID, id), Updates.combine(updates), MongoClients.UPDATE_OPTIONS_UPSERT);

		int ret = ((Long) updateResults.getModifiedCount()).intValue();
		if (0 == ret) {
			ret = null != updateResults.getUpsertedId() ? 1 : 0;
		}
		return ret;
	}

	public static <T> int partialUpdatesByMongo(String collectionName, List<T> entities, Boolean ordered, String... updateFields) {
		if (CollectionUtils.isEmpty(entities)) {
			return 0;
		}
		Class<?> entityClass = entities.get(0).getClass();
		String pkFieldName = Reflects.getCachedPkFieldName(entityClass);
		MongoCollection<Document> collection = MongoClients.getCollection(collectionName, true);

		List<WriteModel<Document>> updateOneModels = Lists.newArrayList();

		for (T entity : entities) {
			if (null == entity) {
				continue;
			}
			Object id = Reflects.invokeCachedGetter(entityClass, entity, Reflects.getCachedPkFieldName(entityClass));
			Document updates = new Document();
			Document updatesSet = new Document(MONGO_FIELD_UPDATE_DATE, new Date()); // 设置mongo的更新时间
			Document updatesUnset = new Document();
			for (String fieldName : updateFields) {
				if (!pkFieldName.equals(fieldName)) {
					Object fieldVal = Reflects.invokeCachedGetter(entityClass, entity, fieldName);
					if (null != fieldVal) {
						updatesSet.append(fieldName, fieldVal);
					} else {
						updatesUnset.append(fieldName, null);
					}
				}
			}
			if (!updatesSet.isEmpty()) {
				updates.append(OP_SET, updatesSet);
			}
			if (!updatesUnset.isEmpty()) {
				updates.append(OP_UNSET, updatesUnset);
			}
			if (!updates.isEmpty()) {
				updateOneModels.add(new UpdateOneModel<Document>(new Document(MongoClients.MONGOID, id), updates, MongoClients.UPDATE_OPTIONS_UPSERT));
			}
		}

		BulkWriteResult bulkWriteResult = collection.bulkWrite(updateOneModels, new BulkWriteOptions().ordered(BooleanUtils.isTrue(ordered)));
		int ret = bulkWriteResult.getUpserts().size();
		// int ret = bulkWriteResult.getModifiedCount() + bulkWriteResult.getUpserts().size();
		return ret;
	}

	public static <T, V> T getByIdByMorphia(Class<T> entityClass, V id) {
		return MongoClients.getDatastore().get(entityClass, id);
	}

	/**
	 * 通过id数组获取记录
	 * 
	 * @param entityClass
	 * @param ids
	 * @param readPrimary 是否读主库
	 * @return
	 */
	public static <T, V> List<T> getByIdsByMorphia(Class<T> entityClass, Iterable<V> ids, boolean readPrimary) {
		Query<T> query = MongoClients.getDatastore().get(entityClass, ids);
		if (readPrimary) {
			query.useReadPreference(ReadPreference.primary());
		}
		return query.asList();
	}

	public static <T, V> T getByIdByMongo(String collectionName, Class<T> entityClass, V id, boolean readPrimary) throws Exception {
		MongoCollection<Document> collection = MongoClients.getCollection(collectionName, readPrimary);
		FindIterable<Document> findIterable = collection.find(Filters.eq(MongoClients.MONGOID, id));
		if (readPrimary) {
			// findIterable.
		}
		Document doc = findIterable.first();
		T ret = entityClass.newInstance();
		String pkFieldName = Reflects.getCachedPkFieldName(entityClass);
		for (Entry<String, Object> fieldEntry : doc.entrySet()) {
			String fieldName = fieldEntry.getKey();
			String entityField = MongoClients.MONGOID.equals(fieldName) ? pkFieldName : fieldName;
			Object fieldVal = fieldEntry.getValue();
			Reflects.setCachedFieldValue(entityClass, ret, entityField, fieldVal);
		}
		return ret;
	}

	public static <T, V> List<T> getByIdsByMongo(String collectionName, final Class<T> entityClass, Iterable<V> ids, Boolean includeDel, boolean readPrimary) throws Exception {
		MongoCollection<Document> collection = MongoClients.getCollection(collectionName, readPrimary);
		final List<T> ret = Lists.newArrayList();
		final String pkFieldName = Reflects.getCachedPkFieldName(entityClass);
		FindIterable<Document> findIterable = collection.find(Filters.in(MongoClients.MONGOID, ids));
		findIterable.forEach(new Block<Document>() {
			@Override
			public void apply(Document doc) {
				try {
					T obj = entityClass.newInstance();

					for (Entry<String, Object> fieldEntry : doc.entrySet()) {
						String fieldName = fieldEntry.getKey();
						String entityField = MongoClients.MONGOID.equals(fieldName) ? pkFieldName : fieldName;
						Object fieldVal = fieldEntry.getValue();
						Reflects.setCachedFieldValue(entityClass, obj, entityField, fieldVal);
					}
					ret.add(obj);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});

		return ret;
	}

	/**
	 * 通过约束条件查询
	 * 
	 * @return
	 */
	public static <T> List<T> queryEqInByMorphia(Class<T> entityClass, Map<String, Object> queries,boolean readPrimary) {
		Query<T> query = MongoClients.getDatastore().createQuery(entityClass);
		if (readPrimary) {
			query.useReadPreference(ReadPreference.primary());
		}
		for (Entry<String, Object> entry : queries.entrySet()) {
			String fieldName = entry.getKey();
			Object fieldVal = entry.getValue();
			if (fieldVal instanceof Iterable) {
				Iterable<?> itr = (Iterable<?>) fieldVal;
				query.field(fieldName).in(itr);
			} else {
				query.field(fieldName).equal(fieldVal);
			}
		}
		List<T> ret = query.asList();
		return ret;
	}
}
