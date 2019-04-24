package com.zhengxin.thread;

/**
 * Created by zhengxin on 18/1/23.
 */
public class EnergySystemTest {

    //将要构建的能量世界中能量盒子数量
    public static final int BOX_AMOUNT = 10;
    //每个盒子初始能量
    public static final double INITIAL_ENERGY = 100;

    public static void main(String[] args){
        EnergySystem eng = new EnergySystem(BOX_AMOUNT, INITIAL_ENERGY);
        for (int i = 0; i < BOX_AMOUNT; i++){
            EnergyTransferTask task = new EnergyTransferTask(eng, i, INITIAL_ENERGY);
            Thread t = new Thread(task,"TransferThread_"+i);
            t.start();
        }
    }

}
