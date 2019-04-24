package com.zhengxin.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhengxin
 * @date 2018-06-26 09:29:54
 */
public interface DAO<T> {

    void update(Connection connection, String sql, Object... args);

    T get(Connection connection, String sql, Object... args) throws SQLException;

    List<T> getForList(Connection connection, String sql, Object... args);

    <E> E getForValue(Connection connection, String sql, Object... args);

    void batch(Connection connection, String sql, Object[]... args);


}
