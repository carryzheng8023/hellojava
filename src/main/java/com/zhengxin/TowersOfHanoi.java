package com.zhengxin;

import java.util.Scanner;

/**
 * @author zhengxin
 * @date 2018-03-17 09:03:11
 */
public class TowersOfHanoi {

    static int m =0;//标记移动次数
    //实现移动的函数
    public static void move(int disks,char N,char M)
    {
        System.out.println("第" + (++m) +" 次移动 : " +" 把 "+ disks+" 号圆盘从 " + N +" ->移到->  " + M);
    }
    //递归实现汉诺塔的函数
    public static void hanoi(int n,char A,char B,char C)
    {
        if(n == 1)//圆盘只有一个时，只需将其从A塔移到C塔
            TowersOfHanoi.move(1, A, C);//将编b号为1的圆盘从A移到C
        else
        {//否则
            hanoi(n - 1, A, C, B);//递归，把A塔上编号1~n-1的圆盘移到B上，以C为辅助塔
            TowersOfHanoi.move(n, A, C);//把A塔上编号为n的圆盘移到C上
            hanoi(n - 1, B, A, C);//递归，把B塔上编号1~n-1的圆盘移到C上，以A为辅助塔
        }
    }
    public static void main(String[] args) {

        char A = 'A';
        char B = 'B';
        char C = 'C';
        System.out.println("******************************************************************************************");
        System.out.println("这是汉诺塔问题（把A塔上编号从小号到大号的圆盘从A塔通过B辅助塔移动到C塔上去");
        System.out.println("******************************************************************************************");
        System.out.print("请输入圆盘的个数：");

        int disks = 64;

        TowersOfHanoi.hanoi(disks, A, B, C);
        System.out.println(">>移动了" + m + "次，把A上的圆盘都移动到了C上");

    }

}
