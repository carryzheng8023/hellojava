package com.zhengxin.pattern.singleton;

/**
 * @author zhengxin
 * @date 2019-03-18 22:13:34
 */
public class Singleton1 {

    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){}

    public void f(){
        System.out.println("Singleton1");
    }

}
