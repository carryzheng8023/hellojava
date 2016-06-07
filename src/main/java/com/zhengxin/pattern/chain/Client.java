package com.zhengxin.pattern.chain;

/**
 * Created by 136931 on 2016/2/26.
 * 责任链模式
 */
public class Client {
    public static void main(String[] args) {

        //组装责任链
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        handlerA.setSuccessor(handlerB);
        //提交请求
        handlerA.handleRequest();
    }
}
