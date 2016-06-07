package com.zhengxin.pattern.visitor;

/**
 * Created by 136931 on 2016/2/29.
 */
public class NodeB extends Node {
    /**
     * 接受方法
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    /**
     * NodeB特有的方法
     */
    public String operationB(){
        return "NodeB";
    }
}
