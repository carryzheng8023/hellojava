package com.zhengxin.concurrency.t13;

/**
 * 两个线程同时监测同一个信号量
 *
 * @author zhengxin
 * @date 2018-02-01 09:03:17
 */
public class SignalDemo3 {

    private volatile int signal;

    public synchronized void set() {

        System.out.println(Thread.currentThread().getName() + " set开始执行...");
        this.signal = 1;
        System.out.println(Thread.currentThread().getName() + " set开始完成...");
        System.out.println(Thread.currentThread().getName() + " set叫醒开始...");
        notifyAll();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " set叫醒完成...");

    }

    public synchronized int get() {

        System.out.println(Thread.currentThread().getName() + " get开始执行...");

        if(signal != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " get完成执行...");

        return signal;
    }


    public static void main(String[] a) {


        SignalDemo3 signalDemo = new SignalDemo3();

        Target1 target1 = new Target1(signalDemo);
        Target2 target2 = new Target2(signalDemo);

        new Thread(target2).start();
        new Thread(target2).start();



        new Thread(target2).start();
        new Thread(target2).start();


        new Thread(target1).start();



    }


}
