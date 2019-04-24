package com.zhengxin.concurrency.t5;

/**
 * 死锁
 * @author zhengxin
 * @date 2018-01-26 15:33:31
 */
public class SisuoDemo {

    private Object obj1 = new Object();
    private Object obj2 = new Object();


    public void a(){
        synchronized (obj1){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2){
                System.out.println("a");
            }
        }
    }

    public void b(){
        synchronized (obj2){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj1){
                System.out.println("b");
            }
        }
    }

    public static void main(String[] a){

        SisuoDemo demo3 = new SisuoDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {

                demo3.a();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                demo3.b();

            }
        }).start();
    }

}
