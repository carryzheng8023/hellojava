package com.zhengxin.pattern.singleton;

/**
 * @author zhengxin
 * @date 2019-03-18 22:29:17
 */
public class Singleton7 {

    private static Singleton7 instance;

    private static class Inner{
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance(){
        return Inner.INSTANCE;
    }

    public void f(){
        System.out.println("Singleton7");
    }
}
