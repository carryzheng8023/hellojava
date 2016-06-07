package com.zhengxin.pattern.iterator;

import java.util.Vector;

/**
 * Created by 136931 on 2016/2/25.
 */
public class ConcreteAggregat implements Aggregat {
    private Vector vector = null;

    public Vector getVector()
    {
        return vector;
    }

    public void setVector(final Vector vector)
    {
        this.vector = vector;
    }

    public ConcreteAggregat()
    {
        vector = new Vector();
        vector.add("vector 1");
        vector.add("vector 2");
        vector.add("vector 3");
        vector.add("vector 4");
        vector.add("vector 5");
    }

    @Override
    public Iterator createIterator()
    {
        return new ConcreteIterator(vector);
    }
}
