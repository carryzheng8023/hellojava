package com.zhengxin.thread;


import org.junit.Test;

/**
 * @author zhengxin
 * @date 2018-05-06 10:08:21
 */
public class TestThread {

    @Test
    public void test1(){
        int num = 1;

        Thread t = new Thread(() -> System.out.println("hello" + num));
        t.start();
    }

}
