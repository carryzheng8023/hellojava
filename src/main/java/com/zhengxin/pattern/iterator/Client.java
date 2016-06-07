package com.zhengxin.pattern.iterator;

/**
 * Created by 136931 on 2016/2/25.
 * 迭代器模式
 */
public class Client {
    public static void main(final String[] args) {
        final Aggregat agg = new ConcreteAggregat();
        final Iterator iterator = agg.createIterator();
        while (!iterator.isDone()) {
            System.out.println(iterator.next());
        }
    }
}
