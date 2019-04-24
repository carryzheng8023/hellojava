package com.zhengxin.timer;

import java.util.TimerTask;

/**
 * @author zhengxin
 * @date 2018-08-13 19:27:45
 */
public class MyTimerTask extends TimerTask {


    private String name;

    public MyTimerTask() {
    }

    public MyTimerTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Current exec name: " + name);
    }
}
