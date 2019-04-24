package com.zhengxin.concurrency.book;

/**
 * @author zhengxin
 * @date 2018-02-03 11:07:30
 */
public class CountOperate extends Thread {

    public CountOperate(Runnable target){
        super(target);
    }



    public CountOperate(){

        System.out.println("CountOperate开始...");

        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());

        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());

        System.out.println("CountOperate结束...");

    }

    @Override
    public void run(){

        System.out.println("run开始...");

        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());

        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());

        System.out.println("run结束...");
    }

    public static void main(String[] args){

        CountOperate c = new CountOperate();

        Thread t1 = new Thread(c);

        System.out.println("主线程开启，t1.isAlive = " + t1.isAlive() + "，c.isAlive = " + c.isAlive());

        c.setName("AAA");
        c.start();

        t1.setName("BBB");
        t1.start();

        System.out.println("主线程结束，t1.isAlive = " + t1.isAlive() + "，c.isAlive = " + c.isAlive() );

    }

}
