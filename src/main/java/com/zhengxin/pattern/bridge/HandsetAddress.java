package com.zhengxin.pattern.bridge;

/**
 * Created by 136931 on 2016/2/25.
 */
public class HandsetAddress implements HandsetSoft {
    @Override
    public void run() {
        System.out.println("运行手机通讯录");
    }
}
