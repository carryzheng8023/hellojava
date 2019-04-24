package com.zhengxin.timer;

import java.util.Timer;

/**
 * @author zhengxin
 * @date 2018-08-13 19:32:40
 */
public class MyTimer {

    public static void main(String[] args) {


        Timer timer = new Timer();
        MyTimerTask task = new MyTimerTask("No.1");

        timer.schedule(task, 2000L, 1000L);

    }
}
