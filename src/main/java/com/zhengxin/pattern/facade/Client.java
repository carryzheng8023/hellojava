package com.zhengxin.pattern.facade;

/**
 * Created by 136931 on 2016/2/23.
 * 外观模式
 */
public class Client {

    public static void main(String[] args){
        Facade facade = new Facade();

        facade.methodA();
        System.out.println("------------------------------------");
        facade.methodB();
        System.out.println("------------------------------------");
        facade.methodC();
    }

}
