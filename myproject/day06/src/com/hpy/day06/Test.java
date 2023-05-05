package com.hpy.day06;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class Test {

    @org.junit.Test
    public void test1(){
        Runnable r1 = () -> System.out.println("hello");
        r1.run();
    }
}
