package com.zhengxin.pattern.builder;

/**
 * Created by 136931 on 2016/2/23.
 * 建造者模式
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director();

        Builder builderA = new ConcreteBuilderA();
        director.construct(builderA);
        Product productA = builderA.retrieveResult();
        productA.show();

        Builder builderB = new ConcreteBuilderB();
        director.construct(builderB);
        Product productB = builderB.retrieveResult();
        productB.show();



    }
}
