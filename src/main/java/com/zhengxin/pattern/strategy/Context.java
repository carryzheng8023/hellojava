package com.zhengxin.pattern.strategy;

/**
 * Created by 136931 on 2016/2/23.
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void contextInterface(){
        strategy.strategyInterface();
    }

}
