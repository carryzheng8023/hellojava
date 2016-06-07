package com.zhengxin.pattern.observer;

/**
 * Created by 136931 on 2016/2/24.
 */
public interface Observer {

    /**
     * 更新接口
     * @param state  更新的状态
     */
    public void update(String state);

}
