package com.zhengxin.pattern.iterator;

import java.util.Vector;

/**
 * Created by 136931 on 2016/2/25.
 */
public class ConcreteIterator implements Iterator {
    private int currentIndex = 0;
    private Vector vector = null;

    public ConcreteIterator(final Vector vector)
    {
        this.vector = vector;
    }

    @Override
    public Object first()
    {
        currentIndex = 0;
        return vector.get(currentIndex);
    }

    @Override
    public Object next()
    {
        return vector.get(currentIndex++);
    }

    @Override
    public Object currentItem()
    {
        return vector.get(currentIndex);
    }

    @Override
    public boolean isDone()
    {
        if (currentIndex >= this.vector.size())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
