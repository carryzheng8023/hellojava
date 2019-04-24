package com.zhengxin.concurrency.t20;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池示例
 *
 * @author zhengxin
 * @date 2018-02-08 17:50:55
 */
public class ThreadPoolDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 50, 3, TimeUnit.DAYS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());


        ExecutorService pool = Executors.newFixedThreadPool(10);
//        ExecutorService pool = Executors.newCachedThreadPool();
//        ExecutorService pool = Executors.newSingleThreadExecutor();
//        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
//        ExecutorService pool = Executors.newWorkStealingPool();



        AtomicInteger count = new AtomicInteger();
        for (;;){

            Future<?> f1 = pool.submit(new Runnable() {
                @Override
                public void run() {

                }
            });

            System.out.println("f1: " + f1.get());



            Future<Integer> f2 = pool.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return 234;
                }
            });

            System.out.println("f2: " + f2.get());



//            pool.execute(new Runnable() {
//                @Override
//                public void run() {
//
//
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println(Thread.currentThread().getName() + " " + count.getAndIncrement());
//                }
//            });

        }




    }


}
