package com.zhengxin.concurrency.t5;

/**
 * 重入锁
 * @author zhengxin
 * @date 2018-01-26 14:44:41
 */
public class ChongrusuoDemo {

    /**
     * synchronized加载方法上锁的就是当前对象实例
     */

    public synchronized void a (){
        System.out.println("a");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        b();
    }


    public synchronized void b (){
        System.out.println("b");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] a){

        ChongrusuoDemo d1 = new ChongrusuoDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                d1.a();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                d1.b();
            }
        }).start();


    }

}
