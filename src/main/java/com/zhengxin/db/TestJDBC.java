package com.zhengxin.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * @author zhengxin
 * @date 2018-06-21 19:34:33
 */
public class TestJDBC {

    /**
     * 调用函数
     * @author zhengxin
     * @date   18/6/26 上午10:30
     */
    @Test
    public void testCallableStatement4(){

        String sql = "select myf2(?)";

        try (Connection connection = JDBCTools.getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql)){

            callableStatement.setObject(1, 1);

            ResultSet rs = callableStatement.executeQuery();

            if(rs.next()){
                System.out.println(rs.getObject(1));
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 调用函数
     * @author zhengxin
     * @date   18/6/26 上午10:30
     */
    @Test
    public void testCallableStatement3(){

        String sql = "select myf1()";

        try (Connection connection = JDBCTools.getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql)){

            ResultSet rs = callableStatement.executeQuery();

            if(rs.next()){
                System.out.println(rs.getObject(1));
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 调用存储过程
     * @author zhengxin
     * @date   18/6/26 上午10:31
     */
    @Test
    public void testCallableStatement2(){

        String sql = "{call myp6(?, ?, ?)}";

        try (Connection connection = JDBCTools.getConnection();
             CallableStatement callableStatement = connection.prepareCall(sql)){

            callableStatement.setObject(1, 1);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.INTEGER);

            callableStatement.execute();

            Object name = callableStatement.getObject(2);
            Object age = callableStatement.getObject(3);

            System.out.println(name);
            System.out.println(age);




        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /**
     * 调用存储过程
     * @author zhengxin
     * @date   18/6/26 上午10:31
     */
    @Test
    public void testCallableStatement(){

        String sql = "{call myp5(?, ?)}";

        try (Connection connection = JDBCTools.getConnection();
                CallableStatement callableStatement = connection.prepareCall(sql)){

            callableStatement.setObject(1, 1);

            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.execute();

            Object name = callableStatement.getObject(2);

            System.out.println(name);




        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void testC3p0WithConfigFile() throws Exception{
        DataSource dataSource = new ComboPooledDataSource("helloc3p0");
        System.out.println(dataSource.getConnection());
        System.out.println(((ComboPooledDataSource)dataSource).getMaxStatements());
    }

    @Test
    public void testC3P0() throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://carryzheng.xin:3306/test");
        dataSource.setUser("zxxx");
        dataSource.setPassword("c5AE@lj-jmZU");

        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testDBCPWithDataSourceFactory() throws Exception{
        Properties properties = new Properties();
        InputStream in = TestJDBC.class.getClassLoader().getResourceAsStream("dbcp.properties");
        properties.load(in);

        DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
        System.out.println(dataSource);
        System.out.println(((BasicDataSource)dataSource).getInitialSize());

        System.out.println(dataSource.getConnection().getClass());
        System.out.println(dataSource.getConnection().getClass());
        System.out.println(">" + dataSource.getConnection().getClass());

//        System.out.println(dataSource.getConnection().getClass());

    }


    @Test
    public void testDBCP() throws Exception{
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUsername("zxxx");
        dataSource.setPassword("c5AE@lj-jmZU");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://carryzheng.xin:3306/test");

        Connection connection = dataSource.getConnection();

        System.out.println(connection) ;
    }


    @Test
    public void readBlob(){
        String sql = "select pic from student where stu_id = 5";

        try (Connection connection = JDBCTools.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

            try(ResultSet rs = statement.executeQuery()) {
                if (rs.next()){
                    Blob pic = rs.getBlob(1);
                    InputStream in = pic.getBinaryStream();
                    OutputStream os = new FileOutputStream(new File("/Users/zhengxin/Desktop/ch.jpg"));
                    int len = 0;
                    byte[] buffer = new byte[1024];
                    while((len = in.read(buffer)) != -1){
                        os.write(buffer, 0, len);
                    }

                    os.close();
                    in.close();
                }


            }catch (Exception e){
                e.printStackTrace();
            }


        }catch (Exception e){
            e.printStackTrace();
        }




    }

    @Test
    public void testInsertBlob(){

        String sql = "insert into student(name, age, pic) values(?,?,?)";

        try (Connection connection = JDBCTools.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, "haa");
            preparedStatement.setInt(2, 36);
            InputStream in = new FileInputStream(new File("/Users/zhengxin/Desktop/陈海.jpg"));
            preparedStatement.setBlob(3,in);

            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testInsertAndGetKey(){
        String sql = "insert into student(name, age) values(?,?)";
        System.out.println(JDBCTools.insertAndGetKey(sql, "zx", 12));
    }


    @Test
    public void testGetList(){

        String sql = "select stu_id stuId, name, age from student";

        System.out.println(JDBCTools.getList(Student.class, sql, null));

    }

    @Test
    public void testGet(){

        String sql = "select stu_id stuId, name, age from student";

        System.out.println(JDBCTools.get(Student.class, sql, null));

    }


    @Test
    public void testResultSetMetaData(){

        String sql = "select stu_id stuId, name, age from student";

        try (Connection connection = JDBCTools.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

            try(ResultSet rs = statement.executeQuery(sql)) {

                ResultSetMetaData resultSetMetaData = rs.getMetaData();

                for(int i=0; i<resultSetMetaData.getColumnCount(); ++i){
                    String columnLabel = resultSetMetaData.getColumnLabel(i+1);
                    System.out.println(columnLabel);
                }

            }catch (Exception e){
                e.printStackTrace();
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testPreparedStatement2(){

        String sql = "insert into student(name, age) values(?,?)";
        JDBCTools.update(sql, "zx", 12);

    }

    @Test
    public void testPreparedStatement(){


        String sql = "insert into student(name, age) values(?,?)";

        try (Connection connection = JDBCTools.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, "hahaaa");
            preparedStatement.setInt(2, 36);

            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testResultSet(){

        try (Connection connection = JDBCTools.getConnection();
        Statement statement = connection.createStatement()){
            String sql = "select * from student";

            try(ResultSet rs = statement.executeQuery(sql)) {
                while (rs.next()){
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int age = rs.getInt(3);

                    System.out.print(id + "\t");
                    System.out.print(name + "\t");
                    System.out.print(age + "\t");
                    System.out.println();
                }


            }catch (Exception e){
                e.printStackTrace();
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void update(String sql){

        try (Connection conn = JDBCTools.getConnection();
             Statement statement = conn.createStatement()){

            statement.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testStatement() throws Exception{
        Connection connection = getConnection2();

        String sql = "insert into student(name, age) values ('lisi', 20)";

        Statement statement = connection.createStatement();
        statement.execute(sql);

        statement.close();
        connection.close();
    }

    @Test
    public void testGetConnection2() throws Exception{
        System.out.println(getConnection2());
    }

    public Connection getConnection2() throws Exception{

        InputStream in = getClass().getClassLoader().getResourceAsStream("db.properties");

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

    @Test
    public void testDriver() throws Exception{

        Driver driver = new com.mysql.jdbc.Driver();

        String url = "jdbc:mysql://carryzheng.xin:3306/test";
        Properties info = new Properties();
        info.put("user", "zxxx");
        info.put("password", "c5AE@lj-jmZU");

        Connection connection = driver.connect(url, info);
        System.out.println(connection);

    }

    @Test
    public void testGetConnection() throws Exception{
        System.out.println(getConnection());
    }

    public Connection getConnection() throws Exception{

        InputStream in = getClass().getClassLoader().getResourceAsStream("db.properties");

        Properties properties = new Properties();
        properties.load(in);
        String driverClass = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        Driver driver = (Driver) Class.forName(driverClass).newInstance();
        Properties info = new Properties();
        info.put("user", username);
        info.put("password", password);

        return driver.connect(url, info);
    }



}
