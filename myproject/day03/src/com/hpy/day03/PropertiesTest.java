package com.hpy.day03;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/25 18:48
 * @description: TODO
 */
public class PropertiesTest {

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
            properties.load(fileInputStream);//加载流对应的文件
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            System.out.println("username:" + username + ",password:" + password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Properties:常用来处理配置文件。key和value都是String类型
    @Test
    public void test(){

    }

}
