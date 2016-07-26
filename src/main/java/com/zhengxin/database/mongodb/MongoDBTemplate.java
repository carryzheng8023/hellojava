package com.zhengxin.database.mongodb;

import com.mongodb.ReadPreference;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MongoDBTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoDBTemplate.class);

    private Datastore ds;

    /**
     *  保存实体
     * @param entity
     * @param <T>
     */
    public <T> void saveObj(T entity){
        getDs().save(entity);
    }

    /**
     *  更新实体(指定字段，为空则删除相应字段)
     * @param entity 实体对象
     * @param field  指定的字段
     * @param <T>    泛型
     * @return
     */
    public <T> int  update(T entity,String ... field){
        return MongoUtils.partialUpdateByMorphia(entity, field);
    }

    /**
     *  更新实体(默认为空则不更新)
     * @param entity  实体对象
     * @param <T>     泛型
     * @return
     */
    public <T> int update(T entity){
        int res = 0;
        ds = getDs();
        if(entity != null){
            try {
                Map<String, Object> describe = PropertyUtils.describe(entity);
                /* 屏蔽类信息 */
                describe.remove("class");
                UpdateOperations updateOperations = ds.createUpdateOperations(entity.getClass());
                Object v = null;
                for (Map.Entry<String, Object> ent : describe.entrySet()) {
                    v = ent.getValue();
                    if(v != null){
                        updateOperations.set(ent.getKey(),v);
                    }
                }
                UpdateResults update = getDs().update(entity, updateOperations);
                res = update.getUpdatedCount();
            } catch (Exception e) {
                LOGGER.error("解析实体出错", e);
            }
        }
        return res;
    }

    public <T> int findAndUpdate(Object id, T entity) {
        int res = 0;

        return res;
    }

    public <T> int update(T entity, Map<String, Object> map){

        int res = 0;
        ds = getDs();
        if(entity != null){
            try {
                Map<String, Object> describe = PropertyUtils.describe(entity);
                /* 屏蔽类信息 */
                describe.remove("class");
                UpdateOperations updateOperations = ds.createUpdateOperations(entity.getClass());
                Object v = null;
                for (Map.Entry<String, Object> ent : describe.entrySet()) {
                    v = ent.getValue();
                    if(v != null){
                        updateOperations.set(ent.getKey(),v);
                    }
                }
                Query query = ds.createQuery(entity.getClass());
                Set<String> keySet = map.keySet();
                for(String key : keySet){
                    query.field(key).equal(map.get(key));
                }
                UpdateResults update = ds.update(query, updateOperations, false);
                res = update.getUpdatedCount();
            } catch (Exception e) {
                LOGGER.error("解析实体出错",e);
            }
        }
        return res;
    }

    /**
     * 按id执行update操作
     * @param clz
     * @param idProperty
     * @param id
     * @param updateOperations
     * @return
     */
    public int findAndIncById(Class clz,String idProperty, Object id,  UpdateOperations updateOperations) {
        ds = getDs();
        Query query = ds.createQuery(clz).filter(idProperty, id);
        ds.findAndModify(query, updateOperations, false); //findAndModify 只查一个
        return 1;
    }

    /**
     *   获取表的所有数据(慎用)
     * @param tClass 对应的实体对象
     * @param <T>
     * @return
     */
    public <T> List<T> findAll(Class<T> tClass){
        Query<T> ts = getDs().find(tClass);
        return ts.asList();
    }

    /**
     *  根据id 获取数据
     * @param clazz  对应的实体类型
     * @param id     id
     * @param <T>    对象类型
     * @param <V>    id的类型
     * @return
     */
    public <T,V> T findByKey(Class<T> clazz ,V id){
        return getDs().get(clazz, id);
    }

    /**
     *  根据id 获取数据
     * @param clazz  对应的实体类型
     * @param <T>    对象类型
     * @param <V>    id的类型
     * @return
     */
    public <T,V> List<T> findByKeys(Class<T> clazz, Iterable<V> it){
        return MongoUtils.getByIdsByMorphia(clazz, it, true);
    }

    /**
     *   分页查询
     * @param clazz  映射类型
     * @param page   分页工具类(需要设置当前页数，以及分页大小(默认20)；也可以设置查询条件)
     * @param <T>
     * @return
     */
    public <T> Pagination<T> findByPage(Class<T> clazz , Pagination page){

        return findByPageWithOrder(clazz, page, null);
    }

    /**
     *   分页加排序
     * @param clazz
     * @param page
     * @param orders
     * @param <T>
     * @return
     */
    public <T>  Pagination<T> findByPageWithOrder(Class<T> clazz , Pagination page,String orders){
        Query<T> query = MongoClients.getDatastore().createQuery(clazz);
        query.useReadPreference(ReadPreference.primary());
        if(page.getQueriesParam() != null){
            Set<Map.Entry<String, Object>> set = page.getQueriesParam().entrySet();
            for (Map.Entry<String, Object> entry : set ) {
                String fieldName = entry.getKey();
                Object fieldVal = entry.getValue();
                if (fieldVal instanceof Iterable) {
                    Iterable<?> itr = (Iterable<?>) fieldVal;
                    query.field(fieldName).in(itr);
                } else {
                    query.field(fieldName).equal(fieldVal);
                }
            }
        }
        if(StringUtils.isNotBlank(orders)){
            query.order(orders);
        }
        Long total = query.countAll();
//        int size = query.getBatchSize();

        page.setTotalCount(total.intValue());
        query.offset((page.getPgaeNum() - 1) * page.getPageSize()).limit(page.getPageSize());
        page.setList(query.asList());
        return page;
    }


    /**
     *   分页查询
     * @param clazz  映射类型
     * @param page   分页工具类(需要设置当前页数，以及分页大小(默认20)；也可以设置查询条件)
     * @param query
     * @param <T>
     * @return
     */
    public <T> Pagination<T> findByPage(Class<T> clazz , Pagination page, Query<T> query){
        query.useReadPreference(ReadPreference.primary());
        Long total = query.countAll();
        int size = query.getBatchSize();
        page.setTotalCount(total.intValue());
        query.offset((page.getPgaeNum() - 1) * page.getPageSize()).limit(page.getPageSize());
        page.setList(query.asList());
        return page;
    }

    /**
     *   根据条件查询
     * @param clazz   映射类型
     * @param queriesParam  查询条件， 如果对象是collection 则使用 in ，负责使用equals
     * @param <T>
     * @return
     */
    public <T> List<T> findByCondition(Class<T> clazz ,Map<String, Object> queriesParam){
        return MongoUtils.queryEqInByMorphia(clazz,queriesParam,true);
    }

    /**
     *  根据id删除数据
     * @param clazz  映射类
     * @param id     id
     * @param <T>    映射类型的泛型
     */
    public <T> void deleteById(Class<T> clazz, Object id){
        getDs().delete(clazz,id);
    }

    /**
     *  根据对象删除数据
     * @param entity  实体对象
     * @param <T>
     */
    public <T> void deleteEntity(T entity){
        getDs().delete(entity);
    }

    /**
     *  根据多个id 删除 数据
     * @param clazz 映射类型
     * @param ids   id列表
     * @param <T>
     */
    public <T> void mutiDeleteByIds(Class<T> clazz, List ids){
        getDs().delete(clazz,ids);
    }

    /**
     *  获取操作DataStore
     * @return
     */
    public Datastore getDs() {
        if(ds == null)
            ds = MongoClients.getDatastore();
        return ds;
    }

    public void setDs(Datastore ds) {
        this.ds = ds;
    }
}
