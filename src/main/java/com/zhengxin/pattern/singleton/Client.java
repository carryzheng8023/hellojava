package com.zhengxin.pattern.singleton;

/**
 * Created by 136931 on 2016/2/25.
 * 单例模式
 */
public class Client {

    public static void main(String[] args){


        Singleton1.INSTANCE.f();
        Singleton2.INSTANCE.f();
        Singleton3.INSTANCE.f();
        Singleton4.getInstance().f();
        Singleton5.getInstance().f();
        Singleton6.getInstance().f();
        Singleton7.getInstance().f();


    }

}
