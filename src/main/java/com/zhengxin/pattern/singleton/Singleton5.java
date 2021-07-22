package com.zhengxin.pattern.singleton;

/**
 * @author zhengxin
 * @date 2019-03-18 22:28:59
 */
public class Singleton5 {

    private static Singleton5 instance;

    private Singleton5(){
        System.out.println(Thread.currentThread().getName() + "\t" + "我是构造方法Singleton5");
    }

    public static Singleton5 getInstance(){

        synchronized (Singleton5.class){
            if(null == instance)
                instance = new Singleton5();
        }

        return instance;
    }

    public void f(){
        System.out.println("Singleton5");
    }
}
