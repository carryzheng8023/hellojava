package com.zhengxin.concurrency.t17;

import java.util.concurrent.Semaphore;

/**
 * @author zhengxin
 * @date 2018-02-04 18:06:52
 */
public class SemaphoreDemo {

    public void method(Semaphore semaphore){

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " 执行中...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphore.release();

    }

    public static void main(String[] a){

        SemaphoreDemo s = new SemaphoreDemo();

        Semaphore semaphore = new Semaphore(10);

        for (;;){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    s.method(semaphore);
                }
            }).start();

        }

    }

}
