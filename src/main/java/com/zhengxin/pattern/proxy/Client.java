package com.zhengxin.pattern.proxy;

/**
 * Created by 136931 on 2016/2/23.
 * 代理模式
 */
public class Client {

    public static void main(String[] args){
        AbstractObject obj = new ProxyObject();
        obj.operation();
    }

}
