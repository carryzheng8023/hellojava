package com.zhengxin.db;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

/**
 * @author zhengxin
 * @date 2018-06-22 16:06:24
 */
public class TestMetaData {


    @Test
    public void testResultSetMetadata(){

    }


    @Test
    public void testDatabaseMetadata(){

        try (Connection connection = JDBCTools.getConnection()){

            DatabaseMetaData databaseMetaData = connection.getMetaData();

            System.out.println(databaseMetaData.getDatabaseMajorVersion());
            System.out.println(databaseMetaData.getDatabaseMinorVersion());
            System.out.println(databaseMetaData.getDatabaseProductVersion());
            System.out.println(databaseMetaData.getDatabaseProductName());
            System.out.println(databaseMetaData.getUserName());

            ResultSet resultSet = databaseMetaData.getCatalogs();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }





        } catch (Exception e){

        }



    }
}
