package com.hpy.day06;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description:
 *
 * Lambda表达式的使用
 * 1.举例：(o1,o2) -> Integer.compare(o1,o2);
 * 2.格式：
 *      ->:Lambda操作符 或 箭头操作符
 *      ->左边：Lambda形参列表（其实就是接口中的抽象方法的形参列表）
 *      ->右边：Lambda体（其实就是重写的抽象方法的方法体）
 *
 * 3.Lambda表达式的使用：（分为6种情况介绍）
 *
 * 4.Lambda表达式的本质：作为函数式接口的实例
 *
 * 5.如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口
 *
 *
 * 总结：
 *      ->左边：Lambda形参列表的参数类型可以省略(类型推断)；如果Lambda形参列表只有一个参数，其一对()也可以省略
 *      ->右边：Lambda体应该使用一对{}包裹；如果Lambda体只有一条执行语句（可能是return语句），省略这一对{}和return关键字
 */
public class LambdaTest {

    //语法格式一：无参，无返回值
    @Test
    public void test1(){
        Runnable r1 = () -> System.out.println("Hello World");
        r1.run();
    }

    //语法格式二：Lambda需要一个参数，但是没弑返回值。
    @Test
    public void test2(){
        Consumer<String> con = (String s) -> System.out.println(s);
        con.accept("hello");
    }
    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test3(){
        Consumer<String> con = (s) -> System.out.println(s);
        con.accept("hello");
    }

    //语法格式四：Lambda若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test4(){
        Consumer<String> con = s -> System.out.println(s);
        con.accept("hello");
    }
    //语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5(){
        Comparator<Integer> com = (o1,o2) ->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        int compare = com.compare(1, 2);
        System.out.println(compare);
    }
    //语法格式六：当Lambda体只有一条语句时，return 与大括号若有，都可以省略
    @Test
    public void test6(){
        Comparator<Integer> com = (o1,o2) -> o1.compareTo(o2);

        int compare = com.compare(1, 2);
        System.out.println(compare);

    }}
