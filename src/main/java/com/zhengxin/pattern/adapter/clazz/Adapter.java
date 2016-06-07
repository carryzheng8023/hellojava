package com.zhengxin.pattern.adapter.clazz;

/**
 * Created by 136931 on 2016/2/24.
 */
public class Adapter extends Adaptee implements Target {

    /**
     * 由于源类Adaptee没有方法sampleOperation2()
     * 因此适配器补充上这个方法
     */
    @Override
    public void sampleOperation2() {
        //写相关的代码
        System.out.println("Adapter : sampleOperation2");
    }
}
