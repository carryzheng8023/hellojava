package com.zhengxin.concurrency.t13;

/**
 * @author zhengxin
 * @date 2018-02-01 09:50:47
 */
public class Target2 implements Runnable {

    private SignalDemo3 signalDemo3;

    public Target2(SignalDemo3 signalDemo3){
        this.signalDemo3 = signalDemo3;
    }

    @Override
    public void run() {
        signalDemo3.get();
    }
}
