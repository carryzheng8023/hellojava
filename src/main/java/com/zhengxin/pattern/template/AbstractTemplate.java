package com.zhengxin.pattern.template;

/**
 * Created by 136931 on 2016/2/23.
 */
public abstract class AbstractTemplate {

    /**
     * 模板方法
     */
    public void templateMethod(){
        //调用基本方法
        abstractMethod();
        hookMethod();
        concreteMethod();
    }

    /**
     * 基本方法的声明（由子类实现）
     */
    protected abstract void abstractMethod();

    /**
     * 基本方法(空方法)
     */
    protected void hookMethod(){
        System.out.println("AbstractTemplate : hookMethod");
    }

    /**
     * 基本方法（已经实现）
     */
    private final void concreteMethod(){
        //业务相关的代码
        System.out.println("AbstractTemplate : concreteMethod");
    }



}
