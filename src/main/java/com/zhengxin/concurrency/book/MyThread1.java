package com.zhengxin.concurrency.book;

/**
 * @author zhengxin
 * @date 2018-02-03 11:38:04
 */
public class MyThread1 extends Thread {


    @Override
    public void run() {
        System.out.println("run thread name = " + this.currentThread().getName() + " begin");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("run thread name = " + this.currentThread().getName() + " end");
    }

    public static void main(String[] a){

        MyThread1 myThread1 = new MyThread1();

        System.out.println("begin = " + System.currentTimeMillis());

//        myThread1.run();
        myThread1.start();

        System.out.println("end = " + System.currentTimeMillis());

    }
}
