package com.zhengxin.innerClass;

/**
 * @author zhengxin
 * @date 2018-02-01 19:20:19
 */
public class Test2 {

    public static void main(String[] args)  {
        Outter outter = new Outter();
        outter.new Inner().print();
    }
}


class Outter
{
    private int a = 1;
    class Inner {
        private int a = 2;
        public void print() {
            int a = 3;
            System.out.println("局部变量：" + a);
            System.out.println("内部类变量：" + this.a);
            System.out.println("外部类变量：" + Outter.this.a);
        }
    }
}
