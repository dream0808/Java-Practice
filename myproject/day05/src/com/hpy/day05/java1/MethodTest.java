package com.hpy.day05.java1;

import com.hpy.day05.java.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description:
 *
 * 获取运行时类的方法结构
 */
public class MethodTest {
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;

        // getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method method:methods) {
            System.out.println(method);
        }
        System.out.println("-----");

        //getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method:declaredMethods) {
            System.out.println(method);
        }

    }
    @Test
    public void test2(){

        //1.获取方法声明的注解
        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m:declaredMethods) {
            Annotation[] annotations = m.getAnnotations();
           for(Annotation a : annotations){
               System.out.println(a);
           }

           //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");


            //3.返回值类型
            Class type = m.getReturnType();
            System.out.print(type.getName() + "\t");


            //4.方法名
            System.out.print(m.getName());

            System.out.print("(");

            Class<?>[] types = m.getParameterTypes();
            if(types.length >0){
                //（type != null || type.length != 0）
                for(int i = 0; i < types.length;i++){

                    if(i == types.length-1){
                        System.out.print(types[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(types[i].getName() + " args_" + i + ",");
                }
            }
            System.out.print(")");
            System.out.println();
        }

    }
}
