package com.zhengxin.concurrency.book;

/**
 * @author zhengxin
 * @date 2018-02-03 11:51:35
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        int j = 0;

        for (int i = 0; i < 500000; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i = " + j++);
        }
    }

//    public static void main(String[] a){
//
//
//        try {
//            MyThread myThread = new MyThread();
//            myThread.start();
//            Thread.sleep(1000);
////            myThread.interrupt();
////            Thread.currentThread().interrupt();
//
//            System.out.println("是否停止1？"  + myThread.interrupted());
//            System.out.println("是否停止2？"  + myThread.interrupted());
//        } catch (InterruptedException e) {
//            System.out.println("main catch");
//
//            e.printStackTrace();
//        }
//
//        System.out.println("end");
//    }

    public static void main(String[] a) {

        Thread.currentThread().interrupt();
        System.out.println("是否停止1？" + Thread.interrupted());
        System.out.println("是否停止2？" + Thread.interrupted());
        System.out.println("end");
    }
}
