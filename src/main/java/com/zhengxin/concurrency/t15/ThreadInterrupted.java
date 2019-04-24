package com.zhengxin.concurrency.t15;

/**
 * @author zhengxin
 * @date 2018-02-01 23:14:03
 */

/**
 * 运行结果：
 *  A点：Thread.interrupted()的结果为false
    B点：Thread.interrupted()的结果为true
    C点：Thread.interrupted()的结果为false
 */
public class ThreadInterrupted {

    public static void main(String[] args) {
        System.out.println("A点：Thread.interrupted()的结果为"+Thread.interrupted());
        //线程中断
        Thread.currentThread().interrupt();
        System.out.println("B点：Thread.interrupted()的结果为"+Thread.interrupted());

        System.out.println("C点：Thread.interrupted()的结果为"+Thread.interrupted());
    }

}
