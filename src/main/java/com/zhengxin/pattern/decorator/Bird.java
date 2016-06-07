package com.zhengxin.pattern.decorator;

/**
 * Created by 136931 on 2016/2/22.
 */
public class Bird extends Change {

    public Bird(TheGreatestSage sage){
        super(sage);
    }

    @Override
    public void move(){
        super.move();
        System.out.println("Bird move");
    }
}
