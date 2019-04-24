package com.zhengxin.concurrency.t6;

/**
 * 保证可见性的前提是
 * 多个线程拿到同一把锁，否则是保证不了的
 * @author zhengxin
 * @date 2018-01-26 16:35:34
 */
public class VolatileDemo {

    private volatile int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.a = a;
    }

    public static void  main(String[] a){


        VolatileDemo demo = new VolatileDemo();

        demo.setA(10);



        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(demo.getA());
            }
        }).start();


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终结果：" + demo.getA());

    }



}
