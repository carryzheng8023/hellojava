package com.zhengxin.concurrency.t13;

import com.zhengxin.concurrency.t1.Target;

/**
 * @author zhengxin
 * @date 2018-02-01 09:50:47
 */
public class Target1 implements Runnable {

    private SignalDemo3 signalDemo3;

    public Target1(SignalDemo3 signalDemo3){
        this.signalDemo3 = signalDemo3;
    }

    @Override
    public void run() {
        signalDemo3.set();
    }
}
