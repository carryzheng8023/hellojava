package com.zhengxin.concurrency.t4;

import java.util.Collection;

/**
 * @author zhengxin
 * @date 2018-01-26 14:33:31
 */
public class Singleton3 {

    private Singleton3(){}

    private static volatile Singleton3 instance;


    /**
     * 双重检查加锁
     *
     * 指令重排序会导致线程不安全
     *
     * @author zhengxin
     * @date   18/1/26 下午2:29
     */
    public static Singleton3 getInstance(){

        if(null == instance) {

            synchronized (Singleton3.class){
                if (null == instance)
                    instance = new Singleton3(); //指令重排序

                    //申请一块内存空间  //1
                    //在这块空间里实例化对象  //2
                    //instance的引用指向内存空间  //3

                    //volatile会减少虚拟机优化

            }


        }
        return instance;
    }

}
