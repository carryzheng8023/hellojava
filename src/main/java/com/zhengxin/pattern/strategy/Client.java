package com.zhengxin.pattern.strategy;

/**
 * Created by 136931 on 2016/2/23.
 * 策略模式
 */
public class Client {

    public static void main(String[] args){

        Context context = null;

        String type = "A";

        switch (type){

            case "A" : context = new Context(new ConcreteStrategyA()); break;
            case "B" : context = new Context(new ConcreteStrategyB()); break;
            case "C" : context = new Context(new ConcreteStrategyC()); break;
            default :
        }

        context.contextInterface();


    }

}
