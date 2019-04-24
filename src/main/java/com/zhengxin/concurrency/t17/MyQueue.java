package com.zhengxin.concurrency.t17;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有界队列
 * @author zhengxin
 * @date 2018-02-02 15:50:23
 */
public class MyQueue<E> {

    private int addIndex = 0;
    private int removeIndex = 0;
    private int queueSize = 0;

    private Object[] obj;

    private Lock lock = new ReentrantLock();

    private Condition addCondition = lock.newCondition();
    private Condition removeCondition = lock.newCondition();

    public MyQueue(int capacity){
        obj = new Object[capacity];
    }

    public void add(E e){

        lock.lock();

        while (obj.length == queueSize){
            try {
                System.out.println(Thread.currentThread().getName() + "队列已满.");
                addCondition.await();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + "添加的对象是：" + e.toString());

        obj[addIndex] = e;



        queueSize++;

        if(++addIndex >= obj.length){
            addIndex = 0;
        }

//        addIndex = (addIndex+1) % obj.length;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        removeCondition.signal();

        lock.unlock();
    }

    public void remove(){

        lock.lock();

        while (queueSize == 0){
            System.out.println(Thread.currentThread().getName() + "队列为空.");
            try {
                removeCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + "移除的对象是：" + obj[removeIndex].toString());

        obj[removeIndex] = null;
        queueSize--;



        if(++removeIndex >= obj.length){
            removeIndex = 0;
        }



        addCondition.signal();


        lock.unlock();

    }

    public static void main(String[] a){


        MyQueue<Double> myQueue = new MyQueue<>(5);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;)
                    myQueue.add(Math.random() * 10);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;)
                    myQueue.remove();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;)
                    myQueue.add(Math.random() * 10);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;)
                    myQueue.remove();
            }
        }).start();


    }



}
