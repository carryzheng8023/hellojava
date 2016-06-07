package com.zhengxin.pattern.visitor;

/**
 * Created by 136931 on 2016/2/29.
 * 访问者模式
 * 数据结构(Node)不变时使用
 */
public class Client {
    public static void main(String[] args) {
        //创建一个结构对象
        ObjectStructure os = new ObjectStructure();
        //给结构增加一个节点
        os.add(new NodeA());
        //给结构增加一个节点
        os.add(new NodeB());
        //创建一个访问者
        Visitor visitor = new VisitorA();
        os.action(visitor);
    }
}
