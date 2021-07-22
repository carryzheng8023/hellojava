package com.zhengxin.pattern.singleton;

/**
 * @author zhengxin
 * @date 2019-03-18 22:28:14
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4(){
        System.out.println(Thread.currentThread().getName() + "\t" + "我是构造方法Singleton4");
    }

    public void f(){
        System.out.println("Singleton4");
    }

    public static Singleton4 getInstance(){
        if(null == instance) {
            instance = new Singleton4();
        }

        return instance;
    }
}
