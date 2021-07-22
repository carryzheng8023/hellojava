package xin.carryzheng.review;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhengxin
 * @date 2021-05-29 13:45:23
 */



class Cache {

    private volatile Map<String, Object> map = new HashMap<>();

    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();


    public void put(String key, Object value){

        try {
            rwLock.writeLock().lock();

            System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);

            try { TimeUnit.MILLISECONDS.sleep(300); }catch(InterruptedException e) { e.printStackTrace(); }

            map.put(key, value);

            System.out.println(Thread.currentThread().getName() + "\t 写入完成");

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwLock.writeLock().unlock();
        }



    }

    public void get(String key){

        try {
            rwLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "\t 正在读取");

            try { TimeUnit.MILLISECONDS.sleep(300); }catch(InterruptedException e) { e.printStackTrace(); }

            Object res = map.get(key);

            System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + res);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwLock.readLock().unlock();
        }

    }

}

public class ReadWriteLockTest {

    public static void main(String[] args) {

        Cache cache = new Cache();


        for (int i = 0; i < 5; i++) {
            final int tmpInt = i;
            new Thread(() -> {
                cache.put(tmpInt+"", tmpInt+"");
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tmpInt = i;
            new Thread(() -> {
                cache.get(tmpInt+"");
            }, String.valueOf(i)).start();
        }

    }

}
