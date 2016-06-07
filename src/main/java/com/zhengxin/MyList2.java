package com.zhengxin;

import java.util.ArrayList;

/**
 * Created by 136931 on 2016/4/13.
 */
public class MyList2<E> {
    private ArrayList<E> list = new ArrayList<>();

    public boolean add(E e) {
        return list.add(e);
    }
}
