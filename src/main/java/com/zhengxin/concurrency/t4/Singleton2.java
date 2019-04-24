package com.zhengxin.concurrency.t4;

/**
 * @author zhengxin
 * @date 2018-01-26 14:17:32
 */
public class Singleton2 {

    private Singleton2(){}

    private static Singleton2 instance;


    /**
     * 偏向锁、轻量级锁 会变成重量级锁
     *
     * @author zhengxin
     * @date   18/1/26 下午2:29
     */
    public static synchronized Singleton2 getInstance(){
        // 自旋: while(true)

        if(null == instance) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton2();
        }
        return instance;
    }

    /**
     * 多线程的环境下
     * 必须有共享资源
     * 对资源进行非原子性操作
     */

}
