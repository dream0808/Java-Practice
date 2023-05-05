package com.hpy.day03;

import org.junit.Test;

import java.util.*;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/24 20:18
 * @description:
 *
 * Set接口：存储无序的、不可重复的数据 -->高中讲的“集合”
 *  |---HashSet:作为Set接口的主要实现类；线程不安全的；可以存储null值
 *    |---LinkedHashSet:作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历
 *  |---TreeSet:可以按照添加对象的指定属性，进行排序。
 *
 *  1.Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法。|
 *
 *  2.要求：向Set中添加的数据，其所在的类一定要重写hashCode()和equals()
 *    要求：重写hashCode()和equals()尽可能保持一致性：相等的对象必须具有相等的散列码
 */
public class SetTest {


    /**
     * 一、Set:存储无序的、不可重复的数据
     * 以HashSet为例说明：
     * 1.无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的
     *
     * 2.不可重复性：保证添加的元素按照equals()判断时，不能返回true.即：相同的元素只能添加一个。
     *
     *
     * 二、添加元素的过程：HashSet为例：
     * 我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
     * 此哈希值接着通过某种算法计算出在hashSet底层数组中的存放位置（即为：索引位置），判断
     * 数组此位置上是否已经有元素：
     *   如果此位置上没有其他元素，则元素a添加成功。--->情况1
     *   如果此位置上有其他元素b(或以链表形式存在的多个元素)，则此较元素a与元素b的hash值：
     *       如果hash值不相同，刚元素a添加成功。--->情况2
     *       如果hash值相同，进而需要调用元素a所在类的equals()方法：
     *          equals()返回true,元素a添加失败
     *          equals()返回false,则元素a添加成功。--->情况3
     *
     *    对于添加成功的情况2和情况3而言：元素a与已经存在指定索引位置上数据以链表的方式存储。
     *    jdk7:元素a放到数组中，指向原来的元素。
     *    jdk8:原来的元素在数组中，指向元素a
     *    总结：七上八下
     */
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Student("Tom",20));
        set.add(false);



        System.out.println(set);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据
    //优点：
    // 对于频繁的遍历操作，LinkedHashSet效率高于HashSet.
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Student("Tom",20));
        set.add(false);



        System.out.println(set);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 1.向TreeSet中添加的数据，要求是相同类的对象。
     * 2.两种排序方式：自然排序(实现Comparable接口)和定制排序
     *
     * 3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.不再是equals().
     * 4.定制排序中，比较两个对象是否相同的标准为：compare()返回0.不再是equals().
     */
    @Test
    public void testTreeSet1(){
        Set set = new TreeSet();

//错误的
//        set.add(123);
//        set.add("AA");
//        set.add("CC");
//        set.add(new Student("Tom",20));
//        set.add(false);

//        set.add(1);
//        set.add(2);
//        set.add(8);
//        set.add(4);
        set.add(new Student("Tom",23));
        set.add(new Student("Bob",20));
        set.add(new Student("Pob",18));
        set.add(new Student("Jerry",25));
        set.add(new Student("Jerry",30));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void testTreeSet2(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
               if(o1 instanceof Student && o2 instanceof Student){
                   Student stu1 = (Student) o1;
                   Student stu2 = (Student) o2;
                   return Integer.compare(stu1.getAge(),stu2.getAge());
               }else{
                   throw new RuntimeException("error");
               }
            }
        };

    TreeSet set = new TreeSet(comparator);

    set.add(new Student("Tom",23));
    set.add(new Student("Bob",20));
    set.add(new Student("Pob",18));
    set.add(new Student("Jerry",25));
    set.add(new Student("Jerry",30));

    Iterator iterator = set.iterator();
    while(iterator.hasNext()){
        System.out.println(iterator.next());
    }


    }
}
