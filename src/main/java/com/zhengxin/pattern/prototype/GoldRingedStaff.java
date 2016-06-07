package com.zhengxin.pattern.prototype;

import java.io.Serializable;

/**
 * Created by 136931 on 2016/2/23.
 */
public class GoldRingedStaff implements Serializable{
    private float height = 100.0f;
    private float diameter = 10.0f;
    /**
     * 增长行为，每次调用长度和半径增加一倍
     */
    public void grow(){
        this.diameter *= 2;
        this.height *= 2;
    }
    /**
     * 缩小行为，每次调用长度和半径减少一半
     */
    public void shrink(){
        this.diameter /= 2;
        this.height /= 2;
    }
}
