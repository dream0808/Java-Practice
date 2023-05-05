package com.hpy.day03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/25 19:03
 * @description:
 *
 *
 * Collections:操作Collection、Map的工具类
 * 面试题：Collection和Collections的区别？
 */
public class CollectionsTest {

    @Test
    public void testCollections(){
        List list = new ArrayList();
        list.add(123);
        list.add(12);
        list.add(-23);
        list.add(13);
        list.add(13);
        list.add(13);

        System.out.println(list);


//        Collections.reverse(list);
//        Collections.shuffle(list);
//        Collections.sort(list);
        Collections.swap(list,0,1);

        System.out.println(Collections.max(list));
        System.out.println(list);
        System.out.println(Collections.frequency(list,13));


        List l = Arrays.asList(new Object[list.size()]);
        Collections.copy(l,list);
        System.out.println(l);

        List synchronizedList = Collections.synchronizedList(list);
        System.out.println(synchronizedList);
    }
}
