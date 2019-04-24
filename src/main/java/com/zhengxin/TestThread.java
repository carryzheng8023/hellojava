package com.zhengxin;

/**
 * @author zhengxin
 * @date 2018-05-11 22:19:18
 */
public class TestThread {

    public static void main(String[] args) {


        Thread t = new Thread(() -> {

            for(int i=0; i<5; ++i){
                System.out.println("子进程, " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        t.start();

        System.out.println("主进程1");

        try {
            t.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主进程2");



    }

}
