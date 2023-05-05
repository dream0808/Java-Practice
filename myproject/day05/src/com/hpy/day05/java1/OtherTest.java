package com.hpy.day05.java1;

import com.hpy.day05.java.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class OtherTest {

    @Test
    public void test(){
        Class clazz = Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }

        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c : declaredConstructors){
            System.out.println(c);
        }
    }

    /**
     * 获取运行时类的父类
     */
    @Test
    public void test2(){
        Class clazz = Person.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }
    /**
     * 获取运行时带泛型的类的父类
     */
    @Test
    public void test3(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }
    /**
     * 获取运行时带泛型的类的父类的泛型
     */
    @Test
    public void test4(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] types = parameterizedType.getActualTypeArguments();
        for(Type t:types){
            System.out.println(t.getTypeName());
        }
    }

    /**
     * 获取运行时类实现的接口
     */
    @Test
    public void test5(){
        Class clazz= Person.class;

        Class[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c : interfaces1){
            System.out.println(c);
        }
    }
    /**
     * 获取运行时类所在的包
     */
    @Test
    public void test6() {
        Class clazz= Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }
/**
 * 获取运行时类声明的注解
 */
    @Test
    public void test7() {

        Class clazz= Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation an :annotations){
            System.out.println(an);
        }
    }
}
