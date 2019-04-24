package com.zhengxin.concurrency.t10;

import java.util.ArrayList;
import java.util.List;

/**
 * 公平锁
 * @author zhengxin
 * @date 2018-01-28 17:04:05
 */
public class FairLock {

    private boolean isLocked = false;
    private Thread lockingThread = null;
    private List<QueueObject> waitingThreads = new ArrayList<>();

    public void lock() throws InterruptedException{

        QueueObject queueObject = new QueueObject();

        boolean isLockedForThisThread = true;

        synchronized (this){
            waitingThreads.add(queueObject);
        }

        //重入
//        while (isLockedForThisThread){
//            synchronized (this){
//                isLockedForThisThread = isLocked || waitingThreads.get(0) != queueObject;
//                if(!isLockedForThisThread){
//                    isLocked = true;
//                    waitingThreads.remove(queueObject);
//                    lockingThread = Thread.currentThread();
//                    return;
//                }
//            }
//        }

        try {
            queueObject.doWait();
        }catch (InterruptedException e){
            synchronized (this){
                waitingThreads.remove(queueObject);
            }
            throw e;

        }

    }

    public synchronized void unlock(){
        if(this.lockingThread != Thread.currentThread()){
            throw new IllegalMonitorStateException("Calling thread has not locked this lock.");
        }

        isLocked = false;

        lockingThread = null;

        if(waitingThreads.size() > 0){
            waitingThreads.get(0).doNotify();
        }
    }



}
