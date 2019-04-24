package com.zhengxin.concurrency.t11;

/**
 * @author zhengxin
 * @date 2018-01-28 19:01:45
 */
public class RWLockTest {

    public static void main(String[] a){


        RWLock rwLock = new RWLock();



        new Thread(new Runnable() {
            @Override
            public void run() {
                rwLock.put("key1", "value1");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(rwLock.get("key1"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(rwLock.get("key1"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(rwLock.get("key1"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(rwLock.get("key1"));
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(rwLock.get("key1"));
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(rwLock.get("key1"));
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                rwLock.put("key3", "value3");
//            }
//        }).start();



    }

}
