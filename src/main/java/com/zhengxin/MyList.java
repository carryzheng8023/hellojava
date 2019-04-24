package com.zhengxin;

import java.util.Iterator;

/**
 * @author zhengxin
 * @date 2018-02-02 08:24:11
 */
public class MyList<E> implements Iterable<E>{

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }
}
