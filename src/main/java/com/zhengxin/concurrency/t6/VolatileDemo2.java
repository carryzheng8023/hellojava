package com.zhengxin.concurrency.t6;

/**
 * volatile是变量在线程间可见
 * @author zhengxin
 * @date 2018-01-26 16:47:50
 */
public class VolatileDemo2 {

    public volatile boolean running = false;


    public static void main(String[] a){


        VolatileDemo2 d = new VolatileDemo2();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=0; i<10; i++){
                    System.out.println(Thread.currentThread().getName() + "执行第" + i + "次");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                d.running = true;

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!d.running){
                    //自旋
                    //不执行
                }
                System.out.println(Thread.currentThread().getName() + "执行了...");
            }
        }).start();

    }

}
