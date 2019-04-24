package com.zhengxin.db;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhengxin
 * @date 2018-06-26 09:34:57
 */
public class BasicDAO<T> implements DAO<T> {

    private QueryRunner queryRunner = null;
    private Class<T> type;

    public BasicDAO(){
        queryRunner = new QueryRunner();
        type = ReflectionUtils.getSuperGenericType(getClass());

    }

    @Override
    public void update(Connection connection, String sql, Object... args) {

    }

    @Override
    public T get(Connection connection, String sql, Object... args) throws SQLException {
        return queryRunner.query(connection, sql, new BeanHandler<>(type), args);
    }

    @Override
    public List<T> getForList(Connection connection, String sql, Object... args) {
        return null;
    }

    @Override
    public <E> E getForValue(Connection connection, String sql, Object... args) {
        return null;
    }

    @Override
    public void batch(Connection connection, String sql, Object[]... args) {

    }
}
