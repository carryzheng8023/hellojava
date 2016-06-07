package com.zhengxin.pattern.builder;

/**
 * Created by 136931 on 2016/2/23.
 */
public class Director {

    /**
     * 持有当前需要使用的建造器对象
     */
    private Builder builder;

    public Director(){}

    /**
     * 构造方法，传入建造器对象
     * @param builder 建造器对象
     */
    public Director(Builder builder){
        this.builder = builder;
    }

    /**
     * 产品构造方法，负责调用各个零件建造方法
     */
    public void construct(Builder builder){
        this.builder = builder;
        builder.buildPart1();
        builder.buildPart2();
    }
}
