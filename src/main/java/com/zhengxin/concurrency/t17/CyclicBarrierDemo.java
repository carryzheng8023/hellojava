package com.zhengxin.concurrency.t17;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author zhengxin
 * @date 2018-02-04 17:40:58
 */
public class CyclicBarrierDemo {


    Random random = new Random();

    public void meeting(CyclicBarrier barrier){

        try {
            Thread.sleep(random.nextInt(4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(Thread.currentThread().getName() + " 等待开会");


        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " 开会等待完成");
    }

    public static void main(String[] a){

        CyclicBarrierDemo clb = new CyclicBarrierDemo();

        CyclicBarrier barrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 好！我们开始开会");
            }
        });

//        CyclicBarrier barrier = new CyclicBarrier(10);

        for(int i=0; i<10; i++){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    clb.meeting(barrier);
                }
            }).start();

        }
    }



}
