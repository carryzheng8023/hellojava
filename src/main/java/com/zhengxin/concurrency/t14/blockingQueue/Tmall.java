package com.zhengxin.concurrency.t14.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhengxin
 * @date 2018-02-01 12:34:46
 */
public class Tmall {



    private final static int MAX_COUNT = 10;

    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(MAX_COUNT);

    public void produce(){

        try {
            queue.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void consume(){
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void size(){

        for(;;){
            System.out.println("当前队列的长度为：" + queue.size());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
