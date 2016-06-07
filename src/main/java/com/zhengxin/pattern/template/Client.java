package com.zhengxin.pattern.template;

/**
 * Created by 136931 on 2016/2/23.
 * 模板方法模式
 */
public class Client {

    public static void main(String[] args){

        AbstractTemplate abstractTemplate = new ConcreteTemplateA();
        abstractTemplate.templateMethod();
        System.out.println("----------------------------------------------");
        abstractTemplate = new ConcreteTemplateB();
        abstractTemplate.templateMethod();

    }

}
