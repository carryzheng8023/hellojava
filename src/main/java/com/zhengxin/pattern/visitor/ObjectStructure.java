package com.zhengxin.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 136931 on 2016/2/29.
 */
public class ObjectStructure {
    private List<Node> nodes = new ArrayList<>();

    /**
     * 执行方法操作
     */
    public void action(Visitor visitor){

        for(Node node : nodes)
        {
            node.accept(visitor);
        }

    }
    /**
     * 添加一个新元素
     */
    public void add(Node node){
        nodes.add(node);
    }
}
