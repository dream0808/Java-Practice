package com.hpy.day06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description:
 *
 * 动态代理的举例
 */

interface Human{
    String getBelief();

    void eat(String food);
}
class superMan implements Human{

    @Override
    public String getBelief() {
        return "fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

/*
要想实现动态代理，需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法。


 */

class ProxyFactory{

    public static Object getProxyInstance(Object obj){//obj:被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
    }

}
class MyInvocationHandler implements InvocationHandler{

    private Object obj;//需要使用被代理类的对象进行赋值
    public void bind(Object obj){
        this.obj = obj;
    }
    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj:被代理类的对象
       Object returnValue = method.invoke(obj,args);

       return returnValue;
    }
}
public class ProxyTest {
    //调用此方法，返回一个代理类的对象
    public static void main(String[] args) {
        superMan superMan = new superMan();
        //proxyInstance:代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("饭");
    }

}
