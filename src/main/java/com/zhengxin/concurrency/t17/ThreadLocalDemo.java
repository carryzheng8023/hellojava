package com.zhengxin.concurrency.t17;

/**
 * @author zhengxin
 * @date 2018-02-03 13:23:30
 */
public class ThreadLocalDemo {


    private ThreadLocal<Integer> count = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return new Integer(0);
        }
    };

    public int getNext(){

        int value = count.get();

        int temp = value;

        count.set(++value);

        return temp;

    }

    public static void main(String[] a){

        ThreadLocalDemo d = new ThreadLocalDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){
                    System.out.println(Thread.currentThread().getName() + " " + d.getNext());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){
                    System.out.println(Thread.currentThread().getName() + " " + d.getNext());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){
                    System.out.println(Thread.currentThread().getName() + " " + d.getNext());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();



    }
}
