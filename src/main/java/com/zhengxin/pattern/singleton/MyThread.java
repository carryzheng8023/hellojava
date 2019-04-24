package com.zhengxin.pattern.singleton;

/**
 * @author zhengxin
 * @date 2018-03-27 16:11:47
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println(Singleton5.getInstance().hashCode());
    }

    public static void main(String[] args) {

        MyThread[] mts = new MyThread[10];
        for(int i = 0 ; i < mts.length ; i++){
            mts[i] = new MyThread();
        }

        for (int j = 0; j < mts.length; j++) {
            mts[j].start();
        }
    }
}
