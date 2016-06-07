package com.zhengxin.pattern.strategy;

/**
 * Created by 136931 on 2016/2/23.
 */
public class ConcreteStrategyA implements Strategy{

    @Override
    public void strategyInterface() {
        System.out.println("策略A");
    }
}
