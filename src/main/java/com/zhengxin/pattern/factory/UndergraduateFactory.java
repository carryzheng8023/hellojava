package com.zhengxin.pattern.factory;

/**
 * Created by 136931 on 2016/2/23.
 */
public class UndergraduateFactory implements IFactory {

    @Override
    public LeiFeng createLeiFeng() {
        return new Undergraduate();
    }
}
