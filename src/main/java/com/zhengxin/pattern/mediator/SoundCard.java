package com.zhengxin.pattern.mediator;

/**
 * Created by 136931 on 2016/2/29.
 */
public class SoundCard extends Colleague {
    public SoundCard(Mediator mediator){
        super(mediator);
    }
    /**
     * 发出声音
     * @param data 音频数据
     */
    public void soundData(String data){
        System.out.println("画外音：" + data);
    }
}
