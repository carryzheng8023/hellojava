package com.zhengxin.jvm;

/**
 * Created by zhengxin on 18/1/24.
 */
public class StackAllocation {


    public StackAllocation obj;

    /**方法返回StackAllocation对象，发生逃逸*/
    public StackAllocation getInstance(){
        return obj == null ? new StackAllocation() : obj;
    }


    /**为成员属性赋值，发生逃逸*/
    public void setObj(){
        this.obj = new StackAllocation();
    }

    /**对象的作用域仅在当前方法中有效，没有发生逃逸*/
    public void useStackAllocation(){
        StackAllocation  s = new StackAllocation();
    }

    /**引用成员变成的值，发生逃逸*/
    public void useStackAllocation2(){
        StackAllocation s = getInstance();
    }





}
