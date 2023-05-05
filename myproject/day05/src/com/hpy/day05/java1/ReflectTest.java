package com.hpy.day05.java1;

import com.hpy.day05.java.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description:
 *
 * 调用运行时类中指定的结构：属性、方法、构造器
 */
public class ReflectTest {

    @Test
    public void testField() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();

        //获取指定的属性：要求运行时类中属性声明为public
        Field pid = clazz.getField("id");
        pid.setAccessible(true);
        /**
         * 设置当前属性的值
         * set():参数1：指明设置哪个对象的属性  参数2：将此属性值设置为多少
         */
        pid.set(p,1001);
        /**
        获取当前属性的值
        get():参数1：获取哪个对象的当前属性值
         */
        System.out.println(pid.get(p));
    }
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();

        //1.getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        //2.保证当前属性是可访问的
        name.setAccessible(true);

        name.set(p,"cxk");
        System.out.println(name.get(p));
    }
    @Test
    public void testMethod() throws Exception{
        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();

       /**
        * 1.获取指定的某个方法
            getDeclaredMethod():参数1：指明获取的方法的名称
                                参数2：指明获取的方法的形参列表
        */
        Method method = clazz.getDeclaredMethod("show", String.class);
        method.setAccessible(true);

        /**
         * invoke():参数1：方法的调用者
         *          参数2：给方法形参赋值的实参
         * invoke()的返回值即为对应类中调用的方法的返回值。
         */
        String str = (String) method.invoke(p, "Chinese");
        System.out.println(str);

        System.out.println("-------------");

        //   private static void showDesc() {

        Method desc = clazz.getDeclaredMethod("showDesc");
        desc.setAccessible(true);
        Object invoke = desc.invoke(Person.class);
        System.out.println(invoke);

    }
    @Test
    public void testConstructor () throws Exception{
        Class clazz = Person.class;
        /**
         * 1.获取指定的构造器
         * getDeclaredConstructor():参数：指明构造器的参数列表
         */
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person person = (Person) constructor.newInstance("cxk");
        System.out.println(person);

    }
}
