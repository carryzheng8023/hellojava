package com.zhengxin.pattern.decorator;

/**
 * Created by 136931 on 2016/2/22.
 */
public class Change implements TheGreatestSage {

    private TheGreatestSage sage;

    public Change(TheGreatestSage sage){
        this.sage = sage;
    }

    @Override
    public void move() {
        this.sage.move();
    }
}
