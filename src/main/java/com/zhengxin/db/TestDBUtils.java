package com.zhengxin.db;

import org.apache.commons.dbutils.QueryLoader;
import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhengxin
 * @date 2018-06-25 21:56:16
 */
public class TestDBUtils {

    QueryRunner queryRunner = new QueryRunner();

    @Test
    public void testQueryLoader() throws IOException {
        // / 代表类路径的根目录.
        Map<String, String> sqls =
                QueryLoader.instance().load("sql.properties");

        String sql = sqls.get("SELECT_STUDENT");
        System.out.println(sql);
    }

    @Test
    public void testScalarHandler(){

        String sql = "select count(*) from student";

        try (Connection connection = JDBCTools.getConnection()){

            Object obj = queryRunner.query(connection, sql, new ScalarHandler<>());

            System.out.println(obj);

        }catch (Exception e){
            e.printStackTrace();
        }

    }



    @Test
    public void testMapListHandler(){

        String sql = "select stu_id stuId, age, name from student";

        try (Connection connection = JDBCTools.getConnection()){

            List<Map<String, Object>> list = queryRunner.query(connection, sql, new MapListHandler());

            System.out.println(list);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void testMapHandler(){

        String sql = "select stu_id stuId, age, name from student where stu_id = ?";

        try (Connection connection = JDBCTools.getConnection()){

            Map<String, Object> map = queryRunner.query(connection, sql, new MapHandler(), 1);

            System.out.println(map);

        }catch (Exception e){
            e.printStackTrace();
        }

    }



    @Test
    public void testBeanListHandler(){

        String sql = "select stu_id stuId, age, name from student";

        try (Connection connection = JDBCTools.getConnection()){

            List<Student> students  = queryRunner.query(connection, sql, new BeanListHandler<>(Student.class));

            System.out.println(students);

        }catch (Exception e){
            e.printStackTrace();
        }

    }




    @Test
    public void testBeanHandler(){

        String sql = "select stu_id stuId, age, name from student where stu_id = ?";

        try (Connection connection = JDBCTools.getConnection()){

            Student student  = queryRunner.query(connection, sql, new BeanHandler<>(Student.class), 1);

            System.out.println(student);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void testQuery(){

        String sql = "select * from student";

        try (Connection connection = JDBCTools.getConnection()){

            List<Student> list = queryRunner.query(connection, sql, (rs) -> {


                    List<Student> studentList = new ArrayList<>();

                    while (rs.next()){
                        Integer stuId = rs.getInt(1);
                        String name = rs.getString(2);
                        Integer age = rs.getInt(3);

                        studentList.add(new Student(stuId, name, age));

                    }
                    return studentList;

            });

            System.out.println(list);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testUpdate(){

        String sql = "delete from student where stu_id = ?";

        try (Connection connection = JDBCTools.getConnection()){

            queryRunner.update(connection, sql, 1);


        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
