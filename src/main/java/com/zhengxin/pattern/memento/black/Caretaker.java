package com.zhengxin.pattern.memento.black;

/**
 * Created by 136931 on 2016/2/24.
 */
public class Caretaker {
    private MementoIF memento;
    /**
     * 备忘录取值方法
     */
    public MementoIF retrieveMemento(){
        return memento;
    }
    /**
     * 备忘录赋值方法
     */
    public void saveMemento(MementoIF memento){
        this.memento = memento;
    }
}
