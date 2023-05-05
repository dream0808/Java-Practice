package com.hpy.day06;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description:
 *
 * 静态代理举例
 *
 * 特点：代理类和被代理类在编译期间，就确定下来了。
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        NikeClothFactory nike = new NikeClothFactory();

        ProxyClothFactory factory = new ProxyClothFactory(nike);

        factory.produceCloth();
    }
}
interface ClothFactory{
    void produceCloth();
}
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;//拿被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂");

        factory.produceCloth();

        System.out.println("后续工作");
    }
}
class NikeClothFactory implements  ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("nike生产衣服");
    }
}