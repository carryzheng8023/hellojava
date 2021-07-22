package com.zhengxin.pattern.singleton;

/**
 * @author zhengxin
 * @date 2019-03-18 22:29:09
 */
public class Singleton6 {

    private static volatile Singleton6 instance;

    private Singleton6(){
        System.out.println(Thread.currentThread().getName() + "\t" + "我是构造方法Singleton6");
    }

    public static Singleton6 getInstance(){

        if(null == instance){
            synchronized (Singleton6.class){
                if(null == instance)
                    instance = new Singleton6();
            }
        }

        return instance;
    }

    public void f(){
        System.out.println("Singleton6");
    }
}
