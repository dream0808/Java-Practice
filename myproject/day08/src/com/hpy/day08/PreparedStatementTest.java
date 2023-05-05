package com.hpy.day08;

import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;


/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class PreparedStatementTest {
   // @Test
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String name = scanner.nextLine();
        System.out.print("请输入密码：");
        String id = scanner.nextLine();
        Properties properties = new Properties();
        properties.load(new FileInputStream("day08\\src\\myjdbc.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "select * from employees where name = ? and id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,id);


        HashMap<Integer, String> map = new HashMap<>();
        //如果执行的是 dml(update,insert,delete) executeUpdate()
        // 这里执行executeQuery,不要再写sql
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            map.put(resultSet.getInt("id"),resultSet.getString("name"));
        }
        map.forEach((key,value) ->{
            System.out.println(key+"-->"+value);
        });
        preparedStatement.close();
        resultSet.close();
        connection.close();
    }
    @SuppressWarnings({"all"})
    @Test
    public void test2() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String name = scanner.nextLine();
        System.out.print("请输入密码：");
        String id = scanner.nextLine();
        Properties properties = new Properties();
        properties.load(new FileInputStream("day08\\src\\myjdbc.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "insert into employees values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,id);


        //如果执行的是 dml(update,insert,delete) executeUpdate()
        // 这里执行executeQuery,不要再写sql
        int row = preparedStatement.executeUpdate();
        if(row > 0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }

        preparedStatement.close();
        connection.close();
    }
}
