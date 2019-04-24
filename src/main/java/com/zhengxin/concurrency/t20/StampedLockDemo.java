package com.zhengxin.concurrency.t20;

import java.util.concurrent.locks.StampedLock;

/**
 * @author zhengxin
 * @date 2018-02-27 14:29:44
 */
public class StampedLockDemo {

    private StampedLock stampedLock = new StampedLock();

    private int balance = 0;

    public void conditionReadWrite(int value){

        //首先判断balance的值是否符合更新的条件
        long stamp = stampedLock.readLock();
        while (balance >= 0){
            long writeStamp = stampedLock.tryConvertToWriteLock(stamp);
            if(writeStamp != 0L){ //成功转换成写锁

                stamp = writeStamp;
                balance += value;
                break;

            }else {//没有转换成写锁，这里首先释放读锁，再获取写锁
                //释放读锁
                stampedLock.unlockRead(stamp);
                //获取写锁
                stamp = stampedLock.writeLock();
            }
        }

        stampedLock.unlock(stamp);

    }

    public void optimisticRead(){

        long stamp = stampedLock.tryOptimisticRead();

        int c = balance;

        //这里可能会出现写操作，因此要进行判断
        if(!stampedLock.validate(stamp)){
            //要重新读取
            stamp = stampedLock.readLock();
            c = balance;
        }
        stampedLock.unlock(stamp);
        System.out.println(c);

    }


    public void read(){

        long s = stampedLock.readLock();

        int c = balance;

        System.out.println(c);

        stampedLock.unlockRead(s);

    }

    public void write(int value){

        long s = stampedLock.writeLock();

        balance += value;

        stampedLock.unlockWrite(s);

    }



}
