package com.zhengxin.pattern.memento.white;

/**
 * Created by 136931 on 2016/2/24.
 */
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
