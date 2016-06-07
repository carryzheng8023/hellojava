package com.zhengxin.pattern.factory;

/**
 * Created by 136931 on 2016/2/23.
 */
public class Volunteer extends LeiFeng {

    @Override
    public void sweep() {
        System.out.println("志愿者扫地");
    }

    @Override
    public void wash() {
        System.out.println("志愿者洗衣");
    }

    @Override
    public void buyRice() {
        System.out.println("志愿者买米");
    }
}
