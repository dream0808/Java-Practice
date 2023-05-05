package com.hpy.day08.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class JDBCUtils {
    private static String url;
    private static String driver;
    private static String user;
    private static String password;

    static{
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\myjdbc.properties"));
             user = properties.getProperty("user");
             password = properties.getProperty("password");
             url = properties.getProperty("url");
             driver = properties.getProperty("driver");

        } catch (IOException e) {
            //在实际开发中，我们可以这样处理
            //1.将编译异常转成运行异常
            //2.这时调用者，可以选择捕获该异常，也可以选择默认处理该异常，比较方便
            throw new RuntimeException(e);
        }



}
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(ResultSet resultSet, Statement statement,Connection connection){
        try {
            if(resultSet != null) resultSet.close();
            if(statement != null) statement.close();
            if(connection != null) connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}