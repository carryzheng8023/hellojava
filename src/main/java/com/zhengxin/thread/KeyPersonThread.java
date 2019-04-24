package com.zhengxin.thread;

/**
 * Created by zhengxin on 18/1/23.
 */
public class KeyPersonThread extends Thread {

    @Override
    public void run(){

        System.out.println(getName() + "开始了战斗");


        for (int i=0; i<10; i++){
            System.out.println(getName()+"左突右杀,攻击隋军"+ "[" + i +"]" +"..." );

        }

        System.out.println(getName() + "结束了战斗");

    }

}
