package com.zhengxin.concurrency.t4;

/**
 * @author zhengxin
 * @date 2018-01-26 14:09:29
 */
public class Main {

    public static void main(String[] a){

        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();

        System.out.println(s1);
        System.out.println(s2);

    }

}
