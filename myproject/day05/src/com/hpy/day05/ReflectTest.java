package com.hpy.day05;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description:
 *
 *
 * 关于java.lang.Class类的理解
 * 1.类的加载过程：
 * 程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)，接着我们使用
 * java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。
 * 此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此运行时类，就作为Class的一个实例。
 *
 * 2.换句话说，Class的实例就对应着一个运行时类。
 *
 * 3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式
 * 来获取此运时类。
 */
public class ReflectTest {

    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Person.class;
        Constructor constructor = clazz.getConstructor(String.class, Integer.class);
        Object obj = constructor.newInstance("Tom", 23);
        Person p = (Person) obj;
        System.out.println(p);

//        Field field = clazz.getDeclaredField("name");
//        field.set(p,"Cxk");

        Method method = clazz.getDeclaredMethod("show");
        method.invoke(p);

        Constructor constructor1 = clazz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Object obj1 = constructor1.newInstance("Jack");
        Person p1 = (Person) obj1;

        System.out.println(p1);

        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(p1,"Marry");

        System.out.println(p1);

        Method nation = clazz.getDeclaredMethod("getNation",String.class);
        nation.setAccessible(true);
        String str = (String) nation.invoke(p1,"Chinese");
        System.out.println(str);
    }
    //获取class实例的方式（前三种方式需要掌握）
    @Test
    public void test2() throws ClassNotFoundException {

        //方式一：调用运行时类的属性：.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象，调用getClass()
        Person p = new Person();
        Class clazz2 = p.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class<?> clazz3 = Class.forName("com.hpy.day05.Person");
        System.out.println(clazz3);

//        System.out.println(clazz1 == clazz2);
//        System.out.println(clazz1 == clazz3);
//        System.out.println(clazz3 == clazz2);

        //方式四：使用类的加载器：ClassLoader(了解)
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.hpy.day05.Person");
        System.out.println(clazz4);

//        System.out.println(clazz1 == clazz4);
//
    }
}
