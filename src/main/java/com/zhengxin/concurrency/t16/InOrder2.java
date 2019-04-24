package com.zhengxin.concurrency.t16;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 按顺序执行方法
 * @author zhengxin
 * @date 2018-02-02 14:52:10
 */
public class InOrder2 {

    private int signal = 0;

    private Lock lock = new ReentrantLock();

    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    public void a(){

        lock.lock();

        while (signal != 0){
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("a");
        signal = 1;
        b.signal();
        lock.unlock();
    }

    public synchronized void b(){
        lock.lock();
        while (signal != 1){
            try {
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("b");
        signal = 2;
        c.signal();
        lock.unlock();
    }

    public synchronized void c(){
        lock.lock();
        while (signal != 2){
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("c");
        signal = 0;
        a.signal();
        lock.unlock();
    }

    public static void main(String[] args){

        InOrder2 inOrder = new InOrder2();

        A a = new A(inOrder);
        B b = new B(inOrder);
        C c = new C(inOrder);

        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();

    }

}


