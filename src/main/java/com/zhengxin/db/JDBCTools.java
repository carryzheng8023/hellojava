package com.zhengxin.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * @author zhengxin
 * @date 2018-06-21 20:41:40
 */
public class JDBCTools {

    private static DataSource dataSource = null;

    static {
        dataSource = new ComboPooledDataSource("helloc3p0");
    }

    public static <T> List<T> getList(Class<T> clazz, String sql, Object... args){

        T entity = null;
        List<T> list = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            if(null != args)
                for (int i=0; i<args.length; ++i)
                    preparedStatement.setObject(i+1, args[i]);

            try (ResultSet resultSet = preparedStatement.executeQuery()){

                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

                while (resultSet.next()){
                    entity = clazz.newInstance();
                    for(int i=0; i< resultSetMetaData.getColumnCount(); ++i){
                        String columnLabel = resultSetMetaData.getColumnLabel(i+1);
                        Object columnValue = resultSet.getObject(columnLabel);
                        ReflectionUtils.setFieldValue(entity, columnLabel, columnValue);
                    }
                    list.add(entity);
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;

    }

    public static <T> T get(Class<T> clazz, String sql, Object... args){

        T entity = null;

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            if(null != args)
                for (int i=0; i<args.length; ++i)
                    preparedStatement.setObject(i+1, args[i]);

            try (ResultSet resultSet = preparedStatement.executeQuery()){

//                Map<String ,Object> values = new HashMap<>();

                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

                if (resultSet.next()){
                    entity = clazz.newInstance();

                    for(int i=0; i< resultSetMetaData.getColumnCount(); ++i){
                        String columnLabel = resultSetMetaData.getColumnLabel(i+1);
                        Object columnValue = resultSet.getObject(columnLabel);

//                        values.put(columnLabel, columnValue);

                        ReflectionUtils.setFieldValue(entity, columnLabel, columnValue);
                    }

                }

//                System.out.println(values);

//                for(Map.Entry<String, Object> entry : values.entrySet()){
//                    String fieldName = entry.getKey();
//                    Object fieldValue = entry.getValue();
//                    System.out.println(fieldName + " : " + fieldValue);
//                    ReflectionUtils.setFieldValue(entity, columnLabel, columnValue);
//                }

//                System.out.println(entity);


            }catch (Exception e){
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return entity;

    }


    public static void update(String sql, Object... args){

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            for(int i=0; i<args.length; ++i)
                preparedStatement.setObject(i+1, args[i]);

            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static int insertAndGetKey(String sql, Object... args){

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            for(int i=0; i<args.length; ++i)
                preparedStatement.setObject(i+1, args[i]);

            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys();){
                if (resultSet.next())
                    return resultSet.getInt(1);
            }catch (Exception e){
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static Connection getConnection() throws Exception{
        return dataSource.getConnection();
    }

    public static Connection getConnection2() throws Exception{

        InputStream in = JDBCTools.class.getClassLoader().getResourceAsStream("db.properties");

        Properties properties = new Properties();
        properties.load(in);
        String driverClass = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        //加载驱动程序（注册驱动）静态代码块
//        DriverManager.registerDriver((Driver) Class.forName(driverClass).newInstance());
        Class.forName(driverClass);

        return DriverManager.getConnection(url, username, password);

    }


    public static void commit(Connection connection){
        if(connection != null){
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void rollback(Connection connection){
        if(connection != null){
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void beginTx(Connection connection){
        if(connection != null){
            try {
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
