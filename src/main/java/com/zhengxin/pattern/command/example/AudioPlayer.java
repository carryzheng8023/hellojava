package com.zhengxin.pattern.command.example;

/**
 * Created by 136931 on 2016/2/25.
 */
public class AudioPlayer {
    public void play(){
        System.out.println("播放...");
    }

    public void rewind(){
        System.out.println("倒带...");
    }

    public void stop(){
        System.out.println("停止...");
    }
}
