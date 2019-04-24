package com.zhengxin.concurrency.t14;

/**
 * 生产者消费者模式测试
 * @author zhengxin
 * @date 2018-02-01 12:45:33
 */
public class Main {


    public static void main(String[] a){

        Tmall tmall = new Tmall();

        ProduceTask produceTask = new ProduceTask(tmall);
        ConsumeTask consumeTask = new ConsumeTask(tmall);

        new Thread(produceTask).start();
        new Thread(produceTask).start();
        new Thread(produceTask).start();
        new Thread(produceTask).start();
        new Thread(produceTask).start();

        new Thread(consumeTask).start();
        new Thread(consumeTask).start();
        new Thread(consumeTask).start();

    }

}
