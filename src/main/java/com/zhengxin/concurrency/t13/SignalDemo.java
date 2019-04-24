package com.zhengxin.concurrency.t13;

/**
 * 两个线程同时监测同一个信号量
 * @author zhengxin
 * @date 2018-02-01 09:03:17
 */
public class SignalDemo {

    private volatile int signal;

    public void set(int value){
        this.signal = value;
    }

    public int get(){
        return this.signal;
    }


    public static void main(String[] a){


        SignalDemo signalDemo = new SignalDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("修改线程开始...");

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                signalDemo.set(1);


                System.out.println("修改线程结束...");


            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (signalDemo.get() != 1){


                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                System.out.println("模拟线程执行...");


            }
        }).start();

    }


}
