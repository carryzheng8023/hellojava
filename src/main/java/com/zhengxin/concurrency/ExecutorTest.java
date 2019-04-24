package com.zhengxin.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhengxin on 18/1/24.
 */
public class ExecutorTest {

    public static void main(String[] a){

        ExecutorService threadPool = Executors.newCachedThreadPool();

        for (int i=0; i<100; i++){

            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }


        threadPool.shutdown();


    }

}
