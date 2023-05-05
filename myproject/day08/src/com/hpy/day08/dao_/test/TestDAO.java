package com.hpy.day08.dao_.test;

import com.hpy.day08.dao_.domain.Employees;
import com.hpy.day08.dao_.dao.EmployeesDAO;
import org.junit.Test;

import java.util.List;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class TestDAO {

    @Test
    public void test1(){
        EmployeesDAO employeesDAO = new EmployeesDAO();

        String sql = "select * from employees";

        List<Employees> employees = employeesDAO.queryMulti(sql, com.hpy.day08.dao_.domain.Employees.class, null);
        employees.forEach(System.out::println);
    }
    @Test
    public void test2(){
        EmployeesDAO employeesDAO = new EmployeesDAO();

        String sql = "select * from employees where id = ?";
        Employees employees = employeesDAO.querySingle(sql, Employees.class, 1001);
        System.out.println(employees);
    }
    @Test
    public void test3(){
        EmployeesDAO employeesDAO = new EmployeesDAO();
        String sql = "select name from employees where id =?;";
        String name = (String) employeesDAO.queryScalar(sql, 1001);
        System.out.println(name);
    }
}
