package com.zhengxin.pattern.decorator;

/**
 * Created by 136931 on 2016/2/22.
 * 装饰模式
 */
public class Client {

    public static void main(String[] args) {
        TheGreatestSage sage = new Monkey();
        sage.move();
        System.out.println("-----------------------------------------");
        TheGreatestSage bird = new Bird(sage);
        bird.move();
        System.out.println("-----------------------------------------");
        TheGreatestSage fish = new Fish(bird);
        fish.move();
    }
}
