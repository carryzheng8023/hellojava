package com.zhengxin.pattern.proxy;

import com.zhengxin.reflect.MyProxy;

/**
 * Created by 136931 on 2016/2/23.
 * 代理模式
 */
public class Client {

    public static void main(String[] args){
        AbstractObject obj = new ProxyObject();
        obj.operation();

        AbstractObject abstractObject = MyProxy.getProxyInstance(new RealObject());
        abstractObject.operation();
    }

}
