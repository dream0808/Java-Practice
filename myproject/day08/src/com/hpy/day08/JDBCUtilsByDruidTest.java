package com.hpy.day08;

import com.hpy.day08.bean.Employees;
import com.hpy.day08.utils.JDBCUtilsByDruid;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class JDBCUtilsByDruidTest {

    //@Test
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入id：");
        String id = scanner.nextLine();
        System.out.print("请输入姓名：");
        String name  = scanner.nextLine();

        PreparedStatement preparedStatement =null;
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "insert into employees values(?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,name);
            int row = preparedStatement.executeUpdate();

            System.out.println(row > 0 ? "成功" : "失败");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,preparedStatement,connection);
            scanner.close();
        }


    }

    @Test
    public void test2(){
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "select * from employees";
        ArrayList<Employees> employees = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet  = preparedStatement.executeQuery();
            while(resultSet.next()){
                employees.add(new Employees(resultSet.getInt("id"),resultSet.getString("name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(resultSet,preparedStatement,connection);
        }

        employees.forEach(System.out::println);
    }
}
