package com.zhengxin.concurrency.t14;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhengxin
 * @date 2018-02-01 12:34:46
 */
public class Tmall {


    private volatile int count;

    private final static int MAX_COUNT = 10;

    public synchronized void produce(){


        System.out.println(Thread.currentThread().getName() + "生产者 开始生产");

        while (count >= MAX_COUNT){
            try {
                System.out.println(Thread.currentThread().getName() + "库存已满 等待消费");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count++;
        System.out.println(Thread.currentThread().getName() + "生产者 生产完成，剩余数量： " + count);
        notifyAll();

    }

    public synchronized void consume(){

        System.out.println(Thread.currentThread().getName() + "消费者 开始消费");

        while (count <= 0){
            System.out.println(Thread.currentThread().getName() + "库存为零 等待生产");

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        System.out.println(Thread.currentThread().getName() + "消费者 消费完成，剩余数量： " + count);
        notifyAll();
    }

}
