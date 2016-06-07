package com.zhengxin.j2se.generics;//: generics/SimpleQueue.java
// A different kind of container that is Iterable

import java.util.Iterator;
import java.util.LinkedList;

public class SimpleQueue<T> implements Iterable<T> {
    private LinkedList<T> storage = new LinkedList<>();

    public void add(T t) {
        storage.offer(t);
    }

    public T get() {
        return storage.poll();
    }

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
} ///:~
