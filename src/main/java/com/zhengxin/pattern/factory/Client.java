package com.zhengxin.pattern.factory;

/**
 * Created by 136931 on 2016/2/23.
 * 工厂模式
 */
public class Client {

    public static void main(String[] args){

        //工厂方法
        IFactory factory = new UndergraduateFactory();
        LeiFeng undergraduate = factory.createLeiFeng();
        undergraduate.buyRice();
        undergraduate.sweep();
        undergraduate.wash();

        //简单工厂方法
        LeiFeng volunteer = SimpleFactory.createLeiFeng("志愿者");
        volunteer.buyRice();
        volunteer.sweep();
        volunteer.wash();

    }

}
