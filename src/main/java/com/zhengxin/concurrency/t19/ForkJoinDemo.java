package com.zhengxin.concurrency.t19;

import java.util.concurrent.*;

/**
 * @author zhengxin
 * @date 2018-02-06 22:35:22
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {

    private int begin;

    private int end;

    public ForkJoinDemo(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        int sum = 0;

        //拆分任务
        if(end - begin <= 2){
            //计算
            for(int i=begin; i<=end; i++)
                sum += i;
        }else {

            //拆分
            ForkJoinDemo d1 = new ForkJoinDemo(begin, (begin+end)/2);
            ForkJoinDemo d2 = new ForkJoinDemo((begin+end)/2+1, end);

            //执行任务
            d1.fork();
            d2.fork();

            Integer a = d1.join();
            Integer b = d2.join();

            sum = a + b;
        }


        return sum;
    }

    public static void main(String[] args) throws Exception {

        long beginTime1 = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();

        Future<Integer> future = pool.submit(new ForkJoinDemo(1, 100000));

        System.out.println("计算的结果1：" + future.get());

        System.out.println((System.currentTimeMillis() - beginTime1) / 1000);

//        long beginTime2 = System.currentTimeMillis();
//
//        int sum = 0;
//
//        for (int j=1;j<=10000000;j++){
//            sum += j;
//        }
//
//        System.out.println("计算的结果2：" + sum);
//
//        System.out.println((System.currentTimeMillis() - beginTime2) / 1000);

    }
}
