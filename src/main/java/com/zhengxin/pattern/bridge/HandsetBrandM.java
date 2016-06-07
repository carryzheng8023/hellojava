package com.zhengxin.pattern.bridge;

/**
 * Created by 136931 on 2016/2/25.
 */
public class HandsetBrandM extends HandsetBrand{

    @Override
    public void run() {
        handsetSoft.run();
    }
}
