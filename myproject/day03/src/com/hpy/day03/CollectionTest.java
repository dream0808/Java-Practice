package com.hpy.day03;

import org.junit.Test;

import java.util.*;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/23 22:52
 * @description: TODO
 */
public class CollectionTest {

    /**
     *
     * 二、集合框架
     * |----Collection.接口：单列集合，用来存储一个一个的对象
     *      |----List接口：存储有序的、可重复的数据.   -->“动态数组
     *          |---ArrayList、LinkedList、Vector
     *      |----Set正接口：存储无序的、不可重复的数据.  -->高中讲的集合”
     *          |----HashSet、LinkedHashSet、TreeSet
     * |---Map接口：双列集合，用来存储一对(key·value)一对的数据
     *          |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
     */
    @Test
    public void testCollection(){
        Collection coll = new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add("CC");
        coll.add(123);
        coll.add(new Date());

        System.out.println(coll.size());
        System.out.println(coll.isEmpty());
        System.out.println(coll);
        coll.clear();
        System.out.println(coll);
    }
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(14);
        coll.add(new String("aa"));
        coll.add(new Student("zs",12));

        boolean contains = coll.contains(new Student("zs",12));
        System.out.println(contains);

        boolean result = coll.remove(123);
        boolean zs = coll.remove(new Student("zs", 12));

        System.out.println(coll);
        System.out.println(result);
        System.out.println(zs);
    }
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(14);
        coll.add(new String("aa"));
        coll.add(new Student("zs",12));
        coll.add(false);

        Collection list = Arrays.asList(1234, 7894,14);
        coll.retainAll(list);

        System.out.println(coll);
    }
    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(14);
        coll.add(new String("aa"));
        coll.add(new Student("zs",12));
        coll.add(false);

        //集合 --> 数组
        Object[] array = coll.toArray();
        System.out.println(coll.hashCode());
        System.out.println(Arrays.toString(array));


        //数组 --> 集合
        List list = Arrays.asList(new String[]{"aa", "bb", "cc"});
        System.out.println(list);
    }
    @Test
    public void testIterator(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(14);
        coll.add(new String("aa"));
        coll.add(new Student("zs",12));
        coll.add(false);

        //集合元素的遍历操作，使用迭代器Iterator接口
        Iterator iterator = coll.iterator();
        //不推荐
//        for (int i = 0; i < coll.size(); i++) {
//             System.out.println(iterator.next());
//
//        }
        //推荐
        while(iterator.hasNext()){//hasNext():判断是否还有下一个元素
            System.out.println(iterator.next());
            //next():①指针下移②将下移以后集合位置上的元素返回
        }

    }
    @Test
    public void test6(){
        Collection coll = new ArrayList<>();
        coll.add(123);
        coll.add(14);
        coll.add(new String("aa"));
        coll.add(new Student("zs",12));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        System.out.println(coll);
        //集合元素的遍历操作，使用迭代器Iterator接口
        //错误的
//        while((iterator.next()) != null){
//            System.out.println(iterator.next());
//        }

        /**
         * 如果还未调用next()或在上一次调用next方法之后已经调用了remove方法
         * 再调用remove都会报IllegalStateException。
         */
        while(iterator.hasNext()){
            Object next = iterator.next();
            if("Tom".equals(next)){
                iterator.remove();
            }
        }
        System.out.println(coll);

    }
    @Test
    public void testFor(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(14);
        coll.add(new String("aa"));
        coll.add(new Student("zs",12));
        coll.add(new String("Tom"));
        coll.add(false);

        //内部仍然调用了迭代器。
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }
}
