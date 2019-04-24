package com.zhengxin.concurrency;

import com.zhengxin.algorithm.alg4.utils.In;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by zhengxin on 18/1/24.
 */
public class CallableTest implements Callable<Integer> {


    public static void main(String[] a) throws Exception{
        CallableTest callableTest = new CallableTest();
        FutureTask<Integer> futureTask = new FutureTask<>(callableTest);

        Thread t = new Thread(futureTask);
        t.start();

        System.out.println("我先干点别的...");

        Integer res = futureTask.get();

        System.out.println("线程计算的结果：" + res);

    }


    @Override
    public Integer call() throws Exception {
        System.out.println("正在紧张的计算中...");

        Thread.sleep(3000);

        return 1;
    }
}
