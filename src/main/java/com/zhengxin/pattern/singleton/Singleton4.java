package com.zhengxin.pattern.singleton;

/**
 * @author zhengxin
 * @date 2019-03-18 22:28:14
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4(){}

    public void f(){
        System.out.println("Singleton4");
    }

    public static Singleton4 getInstance(){
        if(null == instance) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            instance = new Singleton4();

        return instance;
    }
}
