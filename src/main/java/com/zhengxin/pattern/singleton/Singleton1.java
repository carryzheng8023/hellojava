package com.zhengxin.pattern.singleton;

/**
 * @author zhengxin
 * @date 2019-03-18 22:13:34
 */
public class Singleton1 {

    public static final Singleton1 INSTANCE = new Singleton1();


    private Singleton1(){
        System.out.println(Thread.currentThread().getName() + "\t" + "我是构造方法Singleton1");
    }

    public static Singleton1 getInstance(){
        return INSTANCE;
    }

    public void f(){
        System.out.println("Singleton1");
    }

}
