package com.hpy.day05;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class ClassLoadTest {

    @Test
    public void test1(){
        ClassLoader classLoader = ClassLoadTest.class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

    }
    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        properties.load(fis);
        ClassLoader classLoader = ClassLoadTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");

        properties.load(is);

        String user = properties.getProperty("username");
        String password = properties.getProperty("password");

        System.out.println(user);
        System.out.println(password);


    }
}
