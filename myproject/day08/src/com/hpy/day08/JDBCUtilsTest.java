package com.hpy.day08;

import com.hpy.day08.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class JDBCUtilsTest {
    @Test
    public void selectTest()  {
        HashMap<Integer, String> map = new HashMap<>();
        Connection connection = null;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from employees;";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                map.put(resultSet.getInt("id"),resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(resultSet,preparedStatement,connection);
        }

        map.forEach((key,value)->{
            System.out.println(key + "--->" + value);
        });
    }
    @Test
    public void insertTest(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into employees values(?,?);";
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
             preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"1006");
            preparedStatement.setString(2,"周建波");
            int row = preparedStatement.executeUpdate();
            connection.commit();

            System.out.println(row > 0 ? "成功" : "失败");

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);

        }finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }

    @Test
    public void deleteTest(){
        Connection connection = null;

        String sql = "delete from employees where id = ?;";
        PreparedStatement preparedStatement =null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"1007");

            int row = preparedStatement.executeUpdate();
            System.out.println(row > 0 ? "成功" : "失败");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
    @Test
    public void update(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update employees set name = ? where id = ?;";

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"sdcc");
            preparedStatement.setString(2,"1007");

            int row = preparedStatement.executeUpdate();
            System.out.println(row > 0 ? "成功" : "失败");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
}
