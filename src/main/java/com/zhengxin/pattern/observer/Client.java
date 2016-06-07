package com.zhengxin.pattern.observer;

/**
 * Created by 136931 on 2016/2/24.
 * 观察者模式
 */
public class Client {

    public static void main(String[] args) {
        //创建主题对象
        ConcreteSubject subject = new ConcreteSubject();
        //创建观察者对象
        Observer observerA = new ConcreteObserverA("哈哈");
        Observer observerB1 = new ConcreteObserverB("嘿嘿");
        Observer observerB2 = new ConcreteObserverB("呵呵");
        //将观察者对象登记到主题对象上
        subject.attach(observerA);
        subject.attach(observerB1);
        subject.attach(observerB2);
        //改变主题对象的状态
        subject.change("new state");
    }

}
