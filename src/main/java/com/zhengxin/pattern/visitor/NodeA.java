package com.zhengxin.pattern.visitor;

/**
 * Created by 136931 on 2016/2/29.
 */
public class NodeA extends Node {
    /**
     * 接受操作
     */
    @Override
    public void accept(Visitor visitor) {

        visitor.visit(this);
    }
    /**
     * NodeA特有的方法
     */
    public String operationA(){
        return "NodeA";
    }
}
