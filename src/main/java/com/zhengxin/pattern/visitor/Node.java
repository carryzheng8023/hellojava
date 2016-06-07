package com.zhengxin.pattern.visitor;

/**
 * Created by 136931 on 2016/2/29.
 */
public abstract class Node {
    /**
     * 接受操作
     */
    public abstract void accept(Visitor visitor);
}
