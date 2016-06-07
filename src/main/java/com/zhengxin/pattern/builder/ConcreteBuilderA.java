package com.zhengxin.pattern.builder;

/**
 * Created by 136931 on 2016/2/23.
 */
public class ConcreteBuilderA implements Builder{

    private Product product = new Product();

    /**
     * 产品零件建造方法1
     */
    @Override
    public void buildPart1() {
        //构建产品的第一个零件
        product.setPart1("编号：1");
    }

    /**
     * 产品零件建造方法2
     */
    @Override
    public void buildPart2() {
        //构建产品的第二个零件
        product.setPart2("名称：产品A");
    }

    /**
     * 产品返还方法
     */
    @Override
    public Product retrieveResult() {
        return product;
    }

}
