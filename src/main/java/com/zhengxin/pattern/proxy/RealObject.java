package com.zhengxin.pattern.proxy;

/**
 * Created by 136931 on 2016/2/23.
 */
public class RealObject implements AbstractObject {

    @Override
    public void operation() {
        System.out.println("real object");
    }
}
