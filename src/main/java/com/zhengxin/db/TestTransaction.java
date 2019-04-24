package com.zhengxin.db;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author zhengxin
 * @date 2018-06-24 10:20:56
 */
public class TestTransaction {

    @Test
    public void testBatch(){

        String sql = "insert into student(name, age) values('zx', 10)";

        try (Connection connection = JDBCTools.getConnection()){

            JDBCTools.beginTx(connection);

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

                long start = System.currentTimeMillis();

                for(int i=0; i<1000; i++){

                    preparedStatement.addBatch();

                    if( (i+1) % 300 == 0){
                        preparedStatement.executeBatch();
                        preparedStatement.clearBatch();
                    }

                }
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();

                long end = System.currentTimeMillis();

                System.out.println(end - start);

                JDBCTools.commit(connection);


            }catch (Exception e){
                JDBCTools.rollback(connection);
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void testTransaction(){

        String sql1 = "update student set age = age - 10 where stu_id = 4";
        String sql2 = "update student set age = age + 10 where stu_id = 5";

        try (Connection connection = JDBCTools.getConnection()){

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql1)){

                connection.setAutoCommit(false);

                preparedStatement.executeUpdate();

                int i = 10 / 0;
                System.out.println(i);

                preparedStatement.executeUpdate(sql2);

                connection.commit();


            }catch (Exception e){
                connection.rollback();
                e.printStackTrace();
            }


        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
