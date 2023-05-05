package com.hpy.day03;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/24 19:19
 * @description:
 * 面试题：ArrayList、LinkedList、Vector.三者的异同？
 * 同：三个类都是实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
 * 不同：
 *
 * ArrayList:作为List接口的主要实现类，线程不安全的，效率高；底层使用Object[ ]elementData存储
 * LinkedList:对于频繁的插入、删除操作，使用此类效率比ArrayList高；底层使用双向链表存储
 * Vector:作为List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementData存储
 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * ArrayList的源码分析：jdk7情况下
 * ArrayList list=new ArrayList();//底层创建了长度是1B的Object[]数组elementData
 * List.add(123);//elementData[0]new Integer(123);
 * ...
 * List.add(11)//如果此次的添加导致底层elementData数组容量不够，则扩容。
 * 默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
 *
 * 结论：建议开发中使用带参的构造器：ArrayList list=new ArrayList(int capacity);
 */
public class ListTest {

    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);
        list.add("aa");
        list.add(new Student("Tom",18));
        list.add(123);

        System.out.println(list);

        list.add(2,"bb");

        System.out.println(list);

        List list1 = Arrays.asList(123, 14);
        list.addAll(list1);

        System.out.println(list);

        System.out.println(list.get(2).toString());

        //int index0f(Object obj):返回obj在集合中首次出现的位置。如果不存在，返回-1.
        System.out.println(list.indexOf(456));

        System.out.println(list.lastIndexOf(123));

        Object obj = list.remove(0);
        System.out.println(obj);

        System.out.println(list);

        list.set(1,"BB");
        System.out.println(list);
    }
    @Test
    public void test2(){
        ArrayList list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add(789);
        list.add("aa");
        list.add(new Student("Tom",18));
        list.add(123);

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
        System.out.println("***********");

        for (Object obj:list) {
            System.out.println(obj);
        }

        System.out.println("***********");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}



