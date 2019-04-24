package com.zhengxin.concurrency.t1;

/**
 * Created by zhengxin on 18/1/26.
 */
public class Target implements Runnable{

    @Override
    public void run() {

        while (true){
            System.out.println(Thread.currentThread().getName() + "...");

        }

    }
}
