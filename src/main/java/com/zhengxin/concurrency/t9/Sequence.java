package com.zhengxin.concurrency.t9;


/**
 * 使用AQS实现的锁解决线程安全性问题
 * @author zhengxin
 * @date 2018-01-26 17:14:25
 */
public class Sequence {

    private int value;

    private MyLock2 lock = new MyLock2();


    public int getNext() {

        lock.lock();

        try {
            return value++;
        }finally {
            lock.unlock();
        }

    }


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

        Sequence s = new Sequence();


        new Thread(new Runnable() {
            @Override
            public void run() {
                s.a();//测试重入锁
            }
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
