package com.zhengxin.concurrency.t15;

/**
 * @author zhengxin
 * @date 2018-02-01 23:04:27
 */

/**
 * 当flag=false时
 * 输出：当前线程即将sleep的前一条语句
 *      程序没有被中断
        程序运行的时间:20000
    当flag=true时
    输出：当前线程即将sleep的前一条语句
        程序被中断
        程序运行的时间:0
 */
public class PendingInterrupt {
    private static boolean flag;

    public static void main(String[] args) {
        flag = true;
        if (flag) {
            System.out.println("before flag:" + Thread.currentThread().getName());
            Thread.currentThread().interrupt();//中断当前线程
            System.out.println("after flag:" + Thread.currentThread().getName());
        }
        long curTime = System.currentTimeMillis();
        try {//当前线程休眠20秒
            System.out.println("try:" + Thread.currentThread().getName());
            System.out.println("当前线程即将sleep的前一条语句");
            Thread.sleep(20000);
            System.out.println("程序没有被中断");
        } catch (InterruptedException e) {
            System.out.println("catch:" + Thread.currentThread().getName());
            System.out.println("程序被中断");
        }

        System.out.println("程序运行的时间:" + (System.currentTimeMillis() - curTime));

    }
}
