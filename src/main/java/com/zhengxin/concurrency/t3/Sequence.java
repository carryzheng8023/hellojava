package com.zhengxin.concurrency.t3;

/**
 * synchronized修饰静态方法
 * @author zhengxin
 * 2018-01-26 11:11:58
 */
public class Sequence {


    private static int value;

    /**
    * synchronized放在普通方法上，内置锁就是当前内的实例
    * @param
    * @return int
    * @author  zhengxin
    * 18/1/26 上午11:17
    */
    public synchronized int getNext() {

        return value ++;
    }

    /**
     * 修饰静态方法，内置锁是当前的Class字节码对象
     * Sequence.class
     * @param
     * @return int
     * @author zhengxin
     * 18/1/26 上午11:21
    */
    public static synchronized int getPrevious(){
        return value --;
    }

    public int xx(){

        //monitorenter

        synchronized (this){

            if(value > 0){
                return value;
            }else {
                return 0;
            }
        }

        //monitorexit

    }


    public static void main(String[] a){

        Sequence s = new Sequence();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }

}
