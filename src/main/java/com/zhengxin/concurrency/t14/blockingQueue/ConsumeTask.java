package com.zhengxin.concurrency.t14.blockingQueue;

/**
 * @author zhengxin
 * @date 2018-02-01 12:44:13
 */
public class ConsumeTask implements Runnable {


    private Tmall tmall;

    public ConsumeTask(Tmall tmall) {
        this.tmall = tmall;
    }

    @Override
    public void run() {
        for (;;){
            tmall.consume();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
