package com.zhengxin.pattern.adapter.clazz;

/**
 * Created by 136931 on 2016/2/24.
 * 类适配器模式
 */
public class Client {

    public static void main(String[] args){
        Target adapter = new Adapter();
        adapter.sampleOperation1();
        adapter.sampleOperation2();
    }

}
