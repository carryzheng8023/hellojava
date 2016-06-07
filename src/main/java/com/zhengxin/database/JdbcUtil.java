package com.zhengxin.database;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


/**
 * Created by 136931 on 2016/2/25.
 */
public class JdbcUtil {

    /**
     * @Field: pool
     * 数据库连接池
     */
    private static JdbcPool pool = new JdbcPool();

    /**
     * @return Connection数据库连接对象
     * @throws SQLException
     * @Method: getConnection
     * @Description: 从数据库连接池中获取数据库连接对象
     * @Anthor:孤傲苍狼
     */
    public static Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    /**
     * @param conn
     * @param st
     * @param rs
     * @Method: release
     * @Description: 释放资源，
     * 释放的资源包括Connection数据库连接对象，负责执行SQL命令的Statement对象，存储查询结果的ResultSet对象
     * @Anthor:孤傲苍狼
     */
    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                //关闭存储查询结果的ResultSet对象
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (st != null) {
            try {
                //关闭负责执行SQL命令的Statement对象
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                //关闭Connection数据库连接对象
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int insert(String username, String password, Long createDate, Long updateTime){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int id = 0;
        try{
            //获取数据库连接
            conn = JdbcUtil.getConnection();
            String sql = "insert into user(username, password, create_date, update_time) values(?, ?, ?, ?)";
            st = conn.prepareStatement(sql, com.mysql.jdbc.Statement.RETURN_GENERATED_KEYS);
            st.setString(1, username);
            st.setString(2, password);
            st.setLong(3,createDate);
            st.setLong(4,updateTime);

            st.executeUpdate();
            //获取数据库自动生成的主键
            rs = st.getGeneratedKeys();
            if(rs.next()){
//                System.out.println(rs.getInt(1));
                id = rs.getInt(1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            JdbcUtil.release(conn, st, rs);
        }

        return id;
    }

}
