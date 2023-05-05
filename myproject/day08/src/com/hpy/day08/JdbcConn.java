package com.hpy.day08;

import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class JdbcConn {

    @Test
    public void testConn1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
      Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3306/dbtest1?serverTimeZone=UTC";

        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","929957466");

        Connection connect = driver.connect(url, properties);
        System.out.println(connect);

        connect.close();
    }

    //方式3使用DriverManager替代Driver进行统一管理
    @Test
    public void testConn3() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        String url = "jdbc:mysql://localhost:3306/dbtest1?serverTimeZone=UTC";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","929957466");

        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, properties);

        System.out.println(connection);

        connection.close();


    }

    //方式4：使用Class.forName自动完成注册驱动，简化代码
    @Test
    public void testConn4() throws ClassNotFoundException, SQLException {

        /*
        源码：1.静态代码块，在类加载时，会执行一次
         static {
            try {
                DriverManager.registerDriver(new Driver());
            } catch (SQLException var1) {
                throw new RuntimeException("Can't register driver!");
            }
            }
         */
        //1.mysql驱动5.1.6可以无需Class.forName(com.mysql.jdbc.Driver");
        //Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/dbtest1?serverTimeZone=UTC";
        String user = "root";
        String password = "929957466";

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

        connection.close();
    }
    @Test
    public void testConn5() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\myjdbc.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);

        connection.close();


    }
}
