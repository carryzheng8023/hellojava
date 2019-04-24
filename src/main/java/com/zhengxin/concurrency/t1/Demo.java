package com.zhengxin.concurrency.t1;

/**
 * Created by zhengxin on 18/1/26.
 */
public class Demo {

    public static void main(String[] a){

        Thread t1 = new Thread(new Target());
        Thread t2 = new Thread(new Target());


        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();

    }

}
