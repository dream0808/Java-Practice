package com.hpy.day08;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class deleteTest {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);


        System.out.print("请输入id：");
       String id = scanner.nextLine();

        System.out.print("请输入名字：");
        String name = scanner.nextLine();



        Properties properties = new Properties();
        properties.load(new FileInputStream("day08\\src\\myjdbc.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "delete from employees where id = ? and name = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        preparedStatement.setString(2,name);

        int row = preparedStatement.executeUpdate();
        if(row > 0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

}
