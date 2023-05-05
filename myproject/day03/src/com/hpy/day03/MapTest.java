package com.hpy.day03;

import org.junit.Test;

import java.util.*;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/24 22:22
 * @description:
 *
 *
 * 一、Map的实现类的结构：
 * |---- Map:双列数据，存储key-value对的数据  ---类似于高中的函数：y=f(x)
 *      |----HashMap:作为Map的主要实现类；线程不安全的，效率高；可以存储null的key和value
 *          |----LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
 *                             原因：在原有HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *                             对于频繁的遍历操作，此类执行效率高于HashMap。
 *      |----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 *                   底层使用红黑树
 *      |---Hashtable:作为古老的实现类；线程安全的，效率低；不能存储null的key和value
 *          |----Properties:常用来处理配置文件。key和value都是String类型
 *
 *
 *          HashMap的底层：数组+链表 (jdk7及之前)
 *                        数组+链表+红黑树(jdk8)
 *
 *
 * 面试题：
 * 1.HashMap的底层实现原理？
 * 2.HashMap和Hashtable的异同？
 * 3.CurrentHashMap与Hashtable的异同？
 *
 *
 * 二、Map结构的理解：
 *    Map中的key:无序的、不可重复的，使用Set存储所有的key  ---> key所在的类要重写equals()hashCode() (以HashMap为例)
 *    Map中的value:无序的、可重复的，使用Collection存储所有value  --->value所在的类要重写equals()
 *    一个键值对：key-value构成了一个Entry对象。
 *    Map中的Entry:无序的、不可重复的，使用Set存储所有的entry
 *
 * 三、HashMap的底层实现原理？
 *     HashMap map = new HashMap():
 *     在实例化以后，底层创建了长度是16的一维数组Entry[] table。
 *     map.put(key1,value1):
 *     首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置
 *     如果此位置上的数据为空，此时key1-value1添加成功。----情况1
 *     如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表形式存在）)，比较key1和已经存在的一个或多个数据
 *     的哈希值：
 *             如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。----情况2
 *             如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals(key2)
 *             如果equals()返回false:此时key1-value1添加成功.----情况3
 *             如果equals()返回true:使用value1替换value2.
 *
 *         补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储。
 *
 *         在不断的添加过程中，会涉及到扩容问题，默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。
 *
 *     jdk8相较于jdk7在底层实现方面的不同：
 *      1.new HashMap():底层没有创建一个长度为16数组
 *      2.jdk8底层的数组是：Node[],而非Entry[]
 *      3.首次调用put()方法时，底层创建长度为16的数组
 *      4.jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树。
 *      当数组的某个索引位置上的元素以链表形式存在的数据个数 >8 且当前数组的长度 >64时，
 *      此时此索引位置上的所有数据改为使用红黑树存储。
 * I
 */
public class MapTest {

    /**
     *
     * 总结：常用方法
     * 添加： put(Object key,Object value)
     * 删除： remove(Object key)
     * 修政： put(Object key,Object value)
     * 查询： get(Object key)
     * 长度： size()
     * 遍历： keySet() / values() / entrySet()
     *
     */
    @Test
    public void testMap(){
        Map map = new HashMap();
        map.put(123,"AA");
        map.put(12,"BB");
        map.put(1,"CC");

        map.put(1,"ZZ");

        Map map1 = new HashMap();
        map1.put(0,"SS");
        map1.put(7,"KP");
        map1.put(5,"KJ");

        map.putAll(map1);

        System.out.println(map);

        map.remove(0);

        System.out.println(map);

//        map.clear();
//
//        System.out.println(map.size());
//        System.out.println(map);

        Object o = map.get(12);
        System.out.println(o);

        System.out.println(map.containsKey(123));
        System.out.println(map.containsValue("AA"));

        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
    @Test
    public void test2(){
        Map map = new HashMap();
        map.put(123,"AA");
        map.put(12,"BB");
        map.put(1,"CC");

        map.put(5,"ZZ");


        //遍历所有的key集：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("----------");

        //遍历所有的value集：values()
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }
        //遍历所有的key-value
        //entrySet():
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Map.Entry  next = (Map.Entry) iterator1.next();
            System.out.println(next.getKey() + "---->" + next.getValue());
        }


        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while(iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "=====" + value);
        }
    }
    //向TreeMap中添加key-value,要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序、定制排序
    @Test
    public void testTreeMap(){
        TreeMap treeMap = new TreeMap();

        Student s1 = new Student("老刘", 23);
        Student s2 = new Student("洪娟", 21);
        Student s3 = new Student("黄鹏", 24);

        treeMap.put(s1,90);
        treeMap.put(s2,50);
        treeMap.put(s3,100);

//        System.out.println(treeMap);
        Set keySet = treeMap.entrySet();
        Iterator iterator = keySet.iterator();

        while(iterator.hasNext()){
            Object next = iterator.next();
             Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }


    }
    @Test
    public void test3(){
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
               if(o1 instanceof Student && o2 instanceof  Student){
                   Student s1 = (Student) o1;
                   Student s2 = (Student) o2;
                   return Integer.compare(s1.getAge(),s2.getAge());
               }
               throw new RuntimeException("error");
            }
        });

        Student s1 = new Student("老刘", 23);
        Student s2 = new Student("洪娟", 21);
        Student s3 = new Student("黄鹏", 24);

        treeMap.put(s1,90);
        treeMap.put(s2,50);
        treeMap.put(s3,100);

        Set keySet = treeMap.entrySet();
        Iterator iterator = keySet.iterator();

        while(iterator.hasNext()){
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

    }
}
