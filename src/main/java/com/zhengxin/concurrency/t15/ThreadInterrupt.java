package com.zhengxin.concurrency.t15;

/**
 * @author zhengxin
 * @date 2018-02-01 22:57:40
 */
public class ThreadInterrupt implements Runnable {

    public static void main(String[] args) {
        //开启一个线程
        ThreadInterrupt runnable = new ThreadInterrupt();
        Thread t = new Thread(runnable);
        t.start();

        try {
            Thread.sleep(5000);//使main线程休息会，让子线程有时间运行会。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //中断子线程
        System.out.println("main-----即将中断子线程");
        t.interrupt();
        System.out.println("main-----main线程运行结束结束");
    }

    @Override
    public void run() {
        System.out.println("run----子线程正在运行");
        try {
            Thread.sleep(20000);//子线程休息20秒，等待main线程来终端
        } catch (InterruptedException e) {
            System.out.println("run-----子线程在休息的时候被中断");
            return;//如果没有return，则即使线程中断也不会立即返回，他还会继续运行下面的代码
        }

        System.out.println("run-------子线程运行结束");

    }
}
