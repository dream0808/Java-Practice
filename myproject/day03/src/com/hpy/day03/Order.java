package com.hpy.day03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/25 22:32
 * @description: TODO
 */
public class Order<T> {
    String name;
    int id;
    T orderT;

    public Order() {
    }

    public Order(String name, int id, T orderT) {
        this.name = name;
        this.id = id;
        this.orderT = orderT;
    }
    public <E> List<E> copyFromArraysToList(E[] arr){
        ArrayList<E> arrayList = new ArrayList<>();
        for(E e : arr){
            arrayList.add(e);
        }
        return arrayList;
    }
    @Test
    public void test(){
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        print(list1);
        print(list2);

    }
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
