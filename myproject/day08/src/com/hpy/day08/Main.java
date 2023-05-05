package com.hpy.day08;

import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class Main {

    @Test
    public  void selectTest() throws SQLException {

        //1、注册驱动
        HashMap<Integer, String> map = new HashMap<>();
        Driver driver = new Driver();

        //2、得到连接
        //(1) jdbc:mysql://规定好表示协议，通过jdbc的方式连接mysql
        //(2) localhost主机，可以是ip地址
        //(3) 3306表示mysql监听的端口
        //(4) dbtest1连接到mysql dbms的哪个数据库
        //(5)mysql的连接本质就是前面学过的socket连接
        String url = "jdbc:mysql://localhost:3306/dbtest1?serverTimeZone=UTC";

        //将用户名和密码放入到Properties对象
        Properties properties = new Properties();
        //说明 user和password是规定好，后面的值根据实际情况写
        properties.setProperty("user","root");
        properties.setProperty("password","929957466");

        Connection connect = driver.connect(url, properties);

        //3、执行sql
        String sql = "select * from employees";
        //statement用于执行静态SQL语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            map.put(resultSet.getInt("id"),resultSet.getString("name"));
           // System.out.println("id="+resultSet.getString("id")+"\n"+"name=" + resultSet.getString("name"));
        }

        Set<Integer> integers = map.keySet();
        for(Integer i : integers){
            System.out.println(i+"-->" + map.get(i));
        }
        //4、关闭连接
        resultSet.close();
        statement.close();
        connect.close();
    }

    @Test
    public void insertTest() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/dbtest1?serverTimeZone=UTC";

        Driver driver = new Driver();
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","929957466");
        Connection connect = driver.connect(url, properties);
        Statement statement = connect.createStatement();

        String sql = "insert into employees values(1006,'好朋友')";
        int row = statement.executeUpdate(sql);
        if(row > 0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");

        }

        statement.close();
        connect.close();
    }

    @Test
    public void updateTest() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/dbtest1?serverTimeZone=UTC";
        Driver driver = new Driver();
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","929957466");
        Connection connect = driver.connect(url, properties);
        Statement statement = connect.createStatement();

        String sql = "update employees set name = '梁鹏' where id = 1006";
        int row = statement.executeUpdate(sql);
        if(row > 0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");

        }
        statement.close();
        connect.close();
    }

    @Test
    public void deleteTest() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/dbtest1?serverTimeZone=UTC";

        Driver driver = new Driver();
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","929957466");

        Connection connect = driver.connect(url, properties);
        Statement statement = connect.createStatement();

        String sql = "delete from employees where id = 1006";

        int row = statement.executeUpdate(sql);
        if(row > 0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");

        }
        statement.close();
        connect.close();

    }

}