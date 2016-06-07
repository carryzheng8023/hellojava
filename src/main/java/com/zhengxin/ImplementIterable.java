package com.zhengxin;

import java.util.Iterator;

/**
 * Created by 136931 on 2016/3/3.
 */
public class ImplementIterable<T> implements Iterable<T> {

    protected T[] storage;

    public ImplementIterable(T[] storage){
        this.storage = storage;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < storage.length;
            }

            @Override
            public T next() {
                return storage[index++];
            }

            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }

        };
    }
}
