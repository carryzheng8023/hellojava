package com.zhengxin.db;

import org.junit.Test;

import java.sql.Connection;

/**
 * @author zhengxin
 * @date 2018-06-26 09:36:43
 */
public class TestStudentDAO {

    private StudentDAO studentDAO = new StudentDAO();

    @Test
    public void testGet(){


        try (Connection connection = JDBCTools.getConnection()){

            String sql = "select name, age from student where stu_id = ?";

            Student student = studentDAO.get(connection, sql, 1);

            System.out.println(student);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
