package com.zhengxin.pattern.bridge;

/**
 * Created by 136931 on 2016/2/25.
 */
public abstract class HandsetBrand {
    protected HandsetSoft handsetSoft;

    public void setHandsetSoft(HandsetSoft handsetSoft) {
        this.handsetSoft = handsetSoft;
    }

    public abstract void run();
}
