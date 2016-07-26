package com.zhengxin.database.mongodb;

import com.google.common.collect.Maps;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;

import org.apache.commons.lang.StringUtils;
import org.bson.Document;
import org.bson.codecs.BsonTypeClassMap;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

public class MongoClients {
	static final Logger logger = LoggerFactory.getLogger(MongoClients.class);
	// public static final String ENTITYID = "id";
	public static final String           MONGOID = "_id";
	private static final String PRIMARY_KEY = "_primary";
	private static final String SLAVE_KEY = "_slave";
	public static final UpdateOptions UPDATE_OPTIONS_UPSERT = new UpdateOptions().upsert(true);
	private static String MONGODBNAME = null; // "searchdb"; //
	private static String MONGO_CLIENT_URI = null; // "mongodb://searchteam:TooNPro480@172.28.19.195:37019,172.28.19.196:37019,172.28.19.197:37019/searchdb?replicaSet=rs0&maxPoolSize=20&slaveOk=true&readPreference=secondaryPreferred&waitQueueTimeoutMS=3000&waitQueueMultiple=1&authSource=searchdb";
	private static final Object LOCK = new Object();
	private static MongoClient mongoClient = null;
	private static Morphia morphia = null;
	private static Datastore datastore = null;
	public static final BsonTypeClassMap bsonTypeClassMap = new BsonTypeClassMap();
	public static final Map<String, MongoCollection<Document>> MongoCollectionMap = Maps.newConcurrentMap();
	public static final Map<String, MongoDatabase> MongoDatabaseMap = Maps.newConcurrentMap();


	static {
		//在静态代码块中加载db.properties数据库配置文件
		InputStream in = MongoClients.class.getClassLoader().getResourceAsStream("mongodb.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			MONGODBNAME = prop.getProperty("driver");
			MONGO_CLIENT_URI = prop.getProperty("url");

		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static void initializeMongoClient() {
		if (null == mongoClient) {
			synchronized (LOCK) {
				if (null == mongoClient) {
					try {
						logger.info("initializing MongoClient, clientUri:{}", MONGO_CLIENT_URI);
						Builder mongoClientOptionsbuilder = new Builder();

						CodecRegistry defaultCodecRegistry = MongoClient.getDefaultCodecRegistry();
						// Map<BsonType, Class<?>> bsonTypeClassMapData = Maps.newHashMap();
						// bsonTypeClassMapData.put(BsoMongoDBTemplatenType.ARRAY, ArrayList.class);
						// BsonTypeClassMap bsonTypeClassMap = new BsonTypeClassMap(bsonTypeClassMapData);
						// CodecRegistry defaultCodecRegistry = fromProviders(asList(new ValueCodecProvider(), new DBRefCodecProvider(), new DocumentCodecProvider(bsonTypeClassMap,
						// new DocumentToDBRefTransformer()), new DBObjectCodecProvider(), new BsonValueCodecProvider(), new GeoJsonCodecProvider()));

						@SuppressWarnings("unchecked")
						CodecRegistry codecRegistry = CodecRegistries.fromRegistries(defaultCodecRegistry,
								CodecRegistries.fromProviders(new CodecProvider() {
									@Override
									public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
										logger.info("Looking for codec for {}", clazz);
										if (clazz == ArrayList.class) {
											return (Codec<T>) new ArrayListCodec(registry);
										}
										return null;
									}
								}));

						mongoClientOptionsbuilder.codecRegistry(codecRegistry);
						mongoClient = new MongoClient(new MongoClientURI(MONGO_CLIENT_URI, mongoClientOptionsbuilder));

						morphia = new Morphia();

						morphia.setUseBulkWriteOperations(true); // 开启批量模式

						// morphia.mapPackage("com.systoon.daemon", true); // 指定要映射的类
//						morphia.map(Locations.MSDTO_CLASSES);

						datastore = morphia.createDatastore(mongoClient, MONGODBNAME);

						datastore.ensureIndexes();
						datastore.ensureCaps();
					} catch (Exception e) {
						logger.error("initializing MongoClient Error:", e);
					}
				}
			}
		}
	}

	static {
		initializeMongoClient();
	}

	// public static MongoClient getMongoClient() {
	// return mongoClient;
	// }

	public static MongoDatabase getDatabase(String databaseName, boolean usePrimary) {
		if (StringUtils.isNotBlank(databaseName)) {
			String databaseKey = new StringBuilder(databaseName).append(usePrimary ? PRIMARY_KEY : SLAVE_KEY).toString();
			MongoDatabase mongoDatabase = MongoDatabaseMap.get(databaseKey);
			if (null == mongoDatabase) {
				if (usePrimary) {
					mongoDatabase = getDatastore().getMongo().getDatabase(databaseName).withReadPreference(ReadPreference.primary()).withWriteConcern(WriteConcern.ACKNOWLEDGED);
				} else {
					mongoDatabase = getDatastore().getMongo().getDatabase(databaseName).withReadPreference(ReadPreference.secondaryPreferred()).withWriteConcern(WriteConcern.ACKNOWLEDGED);
				}
				MongoDatabaseMap.put(databaseKey, mongoDatabase);
			}
			return mongoDatabase;
		}
		return null;
	}

	public static MongoCollection<Document> getCollection(String collectionName, boolean usePrimary) {
		if (StringUtils.isNotBlank(collectionName)) {
			String collectionKey = new StringBuilder(collectionName).append(usePrimary ? PRIMARY_KEY : SLAVE_KEY).toString();
			MongoCollection<Document> mongoCollection = MongoCollectionMap.get(collectionKey);
			if (null == mongoCollection) {
				mongoCollection = getDatabase(MONGODBNAME, usePrimary).getCollection(collectionName);
				if (usePrimary) {
					mongoCollection.withReadPreference(ReadPreference.primary()).withWriteConcern(WriteConcern.ACKNOWLEDGED);
				} else {
					mongoCollection.withReadPreference(ReadPreference.secondaryPreferred()).withWriteConcern(WriteConcern.ACKNOWLEDGED);
				}
				MongoCollectionMap.put(collectionKey, mongoCollection);
			}
			return mongoCollection;
			// database.getCollection(getCollectionName()).withDocumentClass(Concrete.class).withCodecRegistry(codecRegistry).withReadPreference(ReadPreference.primary())
			// .withWriteConcern(WriteConcern.ACKNOWLEDGED);
		}
		return null;
	}

	public static Morphia getMorphia() {
		return morphia;
	}

	public static Datastore getDatastore() {
		return datastore;
	}

	public static void closeMongoClient() {
		logger.info("closing mongoclient...");
		getDatastore().getMongo().close();
	}

}
