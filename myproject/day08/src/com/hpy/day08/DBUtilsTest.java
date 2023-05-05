package com.hpy.day08;

import com.hpy.day08.bean.Employees;
import com.hpy.day08.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class DBUtilsTest {

    //查询多个对象
    @Test
    public void test1(){
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql ="select * from employees";
        try {
            //(3)   connection: 连接
            //(4)   sql: 执行的sql语句
            //(5)   new BeanListHandler<>(Employees.class): 在将resultSet --> Employees对象 --> 封装到ArrayList
            //底层使用反射机制去获取Employees类的属性，然后进行封装
            //(6) 1 就是给sql语句中的? 赋值，可以有多个值，因为是可变参数
            //(7) 底层得到的resultSet,会在query关闭，关闭PreparedStatement
            List<Employees> list =
                    queryRunner.query(connection, sql, new BeanListHandler<>(Employees.class));

            System.out.println("-----");

            for(Employees employees : list){
                System.out.println(employees);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
    //查询单个对象
    @Test
    public void test2(){
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql ="select * from employees where id =?";

        try {
            Employees employee =
                    queryRunner.query(connection, sql, new BeanHandler<>(Employees.class),1108);
            if(employee != null) System.out.println(employee);
            else System.out.println("不存在");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    //查询单个对象的单个属性
    @Test
    public void test3() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql ="select name from employees where id = ?";
        QueryRunner queryRunner = new QueryRunner();

        String name = queryRunner.query(connection, sql, new ScalarHandler<>(), 1003);

        if (name != null){
            System.out.println(name);
        }else{
            System.out.println("不存在");
        }

        JDBCUtilsByDruid.close(null,null,connection);
    }

    @Test
    public void test4(){
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();

        String sql = "insert into employees values(?,?)";

        try {
            int row = queryRunner.update(connection, sql, 1009, "欣牛逼");

            System.out.println(row > 0 ? "成功" : "失败");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }


    }
}
