package com.hpy.day08;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class insertTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);



        System.out.print("请输入id：");
        Integer id = scanner.nextInt();

        System.out.print("请输入名字：");
        String name = scanner.next();


        Properties properties = new Properties();
        properties.load(new FileInputStream("day08\\src\\myjdbc.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "insert into employees values(?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);


        int row = preparedStatement.executeUpdate();
        if(row > 0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }
}
