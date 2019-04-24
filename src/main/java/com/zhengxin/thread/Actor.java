package com.zhengxin.thread;

/**
 * Created by zhengxin on 18/1/22.
 */
public class Actor extends Thread {

    @Override
    public void run(){

        System.out.println(getName() + "是一个演员");

        int count = 0;

        boolean keepRunning = true;

        while (keepRunning){
            System.out.println(getName() + "演出了" + (++count) + "次");

            if(count == 100){
                keepRunning = false;
            }

            if(count % 10 == 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



        System.out.println(getName() + "的演出结束了");


    }


    public static void main(String[] a){

        Thread actor = new Actor();

        actor.setName("Mr. Thread");

        actor.start();

        Thread actress = new Thread(new Atress(), "Ms. Runnable");
        actress.start();

    }
}

class Atress implements Runnable{

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "是一个演员");

        int count = 0;

        boolean keepRunning = true;

        while (keepRunning){
            System.out.println(Thread.currentThread().getName() + "演出了" + (++count) + "次");

            if(count == 100){
                keepRunning = false;
            }

            if(count % 10 == 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



        System.out.println(Thread.currentThread().getName() + "的演出结束了");


    }
}
