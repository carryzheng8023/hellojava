package com.zhengxin.pattern.observer;

/**
 * Created by 136931 on 2016/2/24.
 */
public class ConcreteObserverA implements Observer {

    private String name;

    //观察者的状态
    private String observerState;

    public ConcreteObserverA(String name){
        this.name = name;
    }

    @Override
    public void update(String state) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = state;
        System.out.println("观察者A-"+ this.name +"状态为：" + observerState);
    }

}
