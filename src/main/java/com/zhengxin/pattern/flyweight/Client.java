package com.zhengxin.pattern.flyweight;

/**
 * Created by 136931 on 2016/2/29.
 * 享元模式
 */
public class Client {
    public static void main(String[] args) {

        FlyweightFactory factory = new FlyweightFactory();
        Flyweight fly = factory.factory(new Character('a'));
        fly.operation("First Call");

        fly = factory.factory(new Character('b'));
        fly.operation("Second Call");

        fly = factory.factory(new Character('a'));
        fly.operation("Third Call");

        System.out.println("实例化数量：" + factory.getInstanceCount());
    }
}
