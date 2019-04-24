package com.zhengxin.concurrency.t12;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 锁降级（写锁降级为读锁）
 * @author zhengxin
 * @date 2018-01-28 18:53:59
 */
public class RWLock {

    private Map<String, Object> map = new HashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock r = readWriteLock.readLock();
    private Lock w = readWriteLock.writeLock();

    private volatile boolean isUpdate;


    public void readWrite(){

        r.lock();

        if(isUpdate){
            r.unlock();

            w.lock();
            map.put("xxx", "xxx");

            r.lock();

            w.unlock();
        }

        Object obj = map.get("xxx");

        System.out.println(obj);

        r.unlock();
    }

    public Object get(String key){
        r.lock();
        System.out.println(Thread.currentThread().getName() + "读操作在执行...");
        try {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return map.get(key);
        }finally {
          r.unlock();
            System.out.println(Thread.currentThread().getName() + "读操作执行完毕...");
        }

    }

    public void put(String key, Object value){
        w.lock();
        System.out.println(Thread.currentThread().getName() + "写操作在执行...");
        try {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
        }finally {
            w.unlock();
            System.out.println(Thread.currentThread().getName() + "写操作执行完毕...");
        }

    }

}
