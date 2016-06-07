package com.zhengxin.pattern.mediator;

/**
 * Created by 136931 on 2016/2/29.
 * 中介者模式
 */
public class Client {
    public static void main(String[] args) {
        MainBoard mediator = new MainBoard();
        CDDriver cd = new CDDriver(mediator);
        CPU cpu = new CPU(mediator);
        VideoCard vc = new VideoCard(mediator);
        SoundCard sc = new SoundCard(mediator);

        mediator.setCdDriver(cd);
        mediator.setCpu(cpu);
        mediator.setVideoCard(vc);
        mediator.setSoundCard(sc);

        cd.readCD();
    }
}
