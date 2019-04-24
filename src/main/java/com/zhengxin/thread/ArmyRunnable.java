package com.zhengxin.thread;

/**
 * Created by zhengxin on 18/1/22.
 */


public class ArmyRunnable implements Runnable{


    //volatile保证了线程可以正确的读取其他线程写入的值
    //可见性 ref JMM， happens-before原则
    volatile boolean keepRunning = true;


    @Override
    public void run() {

        while(keepRunning){

            //发动5连击
            for (int i=0; i<5; i++){
                System.out.println(Thread.currentThread().getName() + "发起了进攻" + "[" + i + "]");

                //进攻1次后让出处理器，下次谁进攻还不一定
                Thread.yield();
            }

            //五连击结束
            System.out.println(Thread.currentThread().getName() + "结束了战斗");




        }

    }
}
