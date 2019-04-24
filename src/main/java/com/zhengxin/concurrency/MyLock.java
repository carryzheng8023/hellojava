package com.zhengxin.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 重入锁，重入会加两把锁
 *
 * Created by zhengxin on 18/1/25.
 */
public class MyLock implements Lock {

    private boolean isLocked = false;

    private Thread lockBy = null;

    private int lockCount = 0;

    @Override
    public synchronized void lock() {

        Thread currentThread = Thread.currentThread();

        while (isLocked && currentThread != lockBy){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        isLocked = true;
        lockBy = currentThread;
        lockCount ++;

    }

    @Override
    public synchronized void unlock() {
        Thread currentThread = Thread.currentThread();

        if (lockBy == currentThread){
            lockCount --;
            if (lockCount == 0){
                isLocked = false;
                notify();

            }
        }



    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
