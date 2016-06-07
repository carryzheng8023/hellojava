package com.zhengxin.pattern.decorator;

/**
 * Created by 136931 on 2016/2/22.
 */
public class Fish extends Change {

    public Fish(TheGreatestSage sage){
        super(sage);
    }

    @Override
    public void move(){
        super.move();
        System.out.println("Fish move");
    }

}
