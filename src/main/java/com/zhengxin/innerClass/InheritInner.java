package com.zhengxin.innerClass;

/**
 * @author zhengxin
 * @date 2018-02-01 19:28:51
 */
public class InheritInner extends WithInner.Inner {

    // InheritInner() 是不能通过编译的，一定要加上形参
    InheritInner(WithInner wi) {
        wi.super(); //必须有这句调用
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner obj = new InheritInner(wi);
    }
}

class WithInner {
    class Inner{

    }
}
