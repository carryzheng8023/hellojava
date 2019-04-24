package com.zhengxin.concurrency.t18;


import java.util.Collections;
import java.util.concurrent.Callable;

import java.util.concurrent.FutureTask;

/**
 * @author zhengxin
 * @date 2018-02-06 14:06:50
 */
public class FutureDemo2 {


    public static void main(String[] args) throws Exception {

        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                System.out.println("正在进行计算2...");

                Thread.sleep(5000);

                FutureTask<Integer> task2 = new FutureTask<>(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {

                        System.out.println("正在进行计算1...");

                        Thread.sleep(5000);

                        return 1;
                    }
                });

                new Thread(task2).start();

                Integer res1 = task2.get();

                System.out.println("结果是1：" + res1);

                return 2;
            }
        });


        new Thread(task).start();

        System.out.println("干点别的...");

        Integer res2 = task.get();

        System.out.println("结果是2：" + res2);

    }

}