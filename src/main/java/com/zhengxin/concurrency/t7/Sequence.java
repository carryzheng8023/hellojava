package com.zhengxin.concurrency.t7;

import com.zhengxin.algorithm.alg4.utils.In;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子类的使用
 * @author zhengxin
 * @date 2018-01-26 17:14:25
 */
public class Sequence {

    private AtomicInteger value = new AtomicInteger(0);

    private int[] s = {1, 3, 4, 5};

    AtomicIntegerArray a = new AtomicIntegerArray(s);

    AtomicReference<User> user = new AtomicReference<>();

    AtomicIntegerFieldUpdater<User> age = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");



    public int getNext() {

        User u = new User();

        System.out.println(age.getAndIncrement(u));
        System.out.println(age.getAndIncrement(u));
        System.out.println(age.getAndIncrement(u));


        return value.getAndAdd(10);
    }


    public static void main(String[] a){

        Sequence s = new Sequence();


        new Thread(new Runnable() {
            @Override
            public void run() {
//                while (true){
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//            }
        }).start();


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
//
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
//
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();


    }
}
