package com.zhengxin.concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhengxin on 18/1/25.
 */
public class MyLockDemo {

    MyLock lock = new MyLock();
//    Lock lock = new ReentrantLock();

    public void a(){
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    public void b(){
        lock.lock();
        System.out.println("b");
        c();
        lock.unlock();
    }

    public void c(){
        lock.lock();
        System.out.println("c");
        lock.unlock();
    }

    public static void main(String[] a){
        MyLockDemo demo = new MyLockDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.a();
            }
        }).start();



    }

}
