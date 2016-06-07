package com.zhengxin.pattern.iterator;

/**
 * Created by 136931 on 2016/2/25.
 */
public interface Iterator {

    public Object first();

    public Object next();

    public Object currentItem();

    public boolean isDone();
}
