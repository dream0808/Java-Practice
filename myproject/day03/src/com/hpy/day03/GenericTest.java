package com.hpy.day03;

import org.junit.Test;

import java.util.*;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/25 22:09
 * @description: TODO
 */
public class GenericTest {
    @Test
    public void test1(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(45);
        list.add(90);
        list.add(78);
        list.add(89);

        System.out.println(list);

        for (Integer i: list) {
            System.out.println(i);
        }

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test3(){
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Tom",89);
        map.put("Jack",88);
        map.put("Bob",80);
        map.put("Mike",90);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
//            System.out.println(iterator.next());
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println("key：" + key + "，value:" + value);
        }


    }

}
