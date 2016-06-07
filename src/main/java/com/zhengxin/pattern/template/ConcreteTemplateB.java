package com.zhengxin.pattern.template;

/**
 * Created by 136931 on 2016/2/23.
 */
public class ConcreteTemplateB extends AbstractTemplate {

    //基本方法的实现
    @Override
    protected void abstractMethod() {
        //业务相关的代码
        System.out.println("ConcreteTemplateB : abstractMethod");
    }

    //重写父类的方法
    @Override
    public void hookMethod() {
        //业务相关的代码
        System.out.println("ConcreteTemplateB : hookMethod");
    }
}
