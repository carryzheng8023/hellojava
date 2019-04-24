package com.zhengxin.concurrency.t14.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhengxin
 * @date 2018-02-01 12:34:46
 */
public class Tmall {


    private volatile int count;

    private final static int MAX_COUNT = 10;

    private Lock lock = new ReentrantLock();

    Condition p = lock.newCondition();
    Condition c = lock.newCondition();


    public void produce(){

        lock.lock();

        System.out.println(Thread.currentThread().getName() + "生产者 开始生产");

        while (count >= MAX_COUNT){
            try {
                System.out.println(Thread.currentThread().getName() + "库存已满 等待消费");
                p.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count++;
        System.out.println(Thread.currentThread().getName() + "生产者 生产完成，剩余数量： " + count);
        c.signal();
        lock.unlock();

    }

    public void consume(){

        lock.lock();

        System.out.println(Thread.currentThread().getName() + "消费者 开始消费");

        while (count <= 0){
            System.out.println(Thread.currentThread().getName() + "库存为零 等待生产");

            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        System.out.println(Thread.currentThread().getName() + "消费者 消费完成，剩余数量： " + count);
        p.signal();
        lock.unlock();
    }

}
