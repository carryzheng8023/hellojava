package com.zhengxin.concurrency.t14.condition;

/**
 * @author zhengxin
 * @date 2018-02-01 12:44:13
 */
public class ProduceTask implements Runnable {


    private Tmall tmall;


    public ProduceTask(Tmall tmall) {
        this.tmall = tmall;
    }

    @Override
    public void run() {
        for (;;) {
            tmall.produce();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
