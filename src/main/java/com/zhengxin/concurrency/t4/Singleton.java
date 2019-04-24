package com.zhengxin.concurrency.t4;

/**
 * 单例模式
 * @author zhengxin
 * @date   2018-01-26 14:04:54
 */
public class Singleton {


    /**
     * 私有化构造方法
     * @author zhengxin
     * 18/1/26 下午2:06
     */
    private Singleton(){}

    /**
     * 饿汉式创建（不支持多线程）
     * @author zhengxin
     * 18/1/26 下午2:11
     */
    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }

    /**
     * 多线程的环境下
     * 必须有共享资源
     * 对资源进行非原子性操作
     */

}
