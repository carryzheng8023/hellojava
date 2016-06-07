package com.zhengxin.pattern.state;

/**
 * Created by 136931 on 2016/2/24.
 */
public interface State {
    /**
     * 状态对应的处理
     */
    public void handle(String sampleParameter);
}
