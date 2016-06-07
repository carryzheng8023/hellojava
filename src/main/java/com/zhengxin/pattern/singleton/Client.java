package com.zhengxin.pattern.singleton;

/**
 * Created by 136931 on 2016/2/25.
 * 单例模式
 */
public class Client {

    public static void main(String[] args){

        System.out.println(Singleton.INSTANCE);

        Singleton.INSTANCE.methodA();
        Singleton.INSTANCE.methodB();
        System.out.println(Singleton.INSTANCE.generatePrimaryKey());


    }

}
