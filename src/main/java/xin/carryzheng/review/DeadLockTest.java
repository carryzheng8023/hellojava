package xin.carryzheng.review;

import sun.misc.Launcher;

import java.util.concurrent.TimeUnit;

/**
 * @author zhengxin
 * @date 2021-06-09 17:11:59
 */

class HoldLockThread implements Runnable{

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {

        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + "\t 自己持有："  + lockA + "\t尝试获得：" + lockB);
            try { TimeUnit.SECONDS.sleep(2); }catch(InterruptedException e) { e.printStackTrace(); }

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "\t 自己持有："  + lockB + "\t尝试获得：" + lockA);
            }

        }

    }
}


public class DeadLockTest {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA, lockB), "AAA").start();
        new Thread(new HoldLockThread(lockB, lockA), "BBB").start();
    }






}
