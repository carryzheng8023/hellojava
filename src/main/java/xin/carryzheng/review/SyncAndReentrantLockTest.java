package xin.carryzheng.review;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhengxin
 * @date 2021-06-07 17:14:23
 */

class SharedResource{

    private int number = 1; // A 1, B 2, C 3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

   public void print5(){
       try {
           lock.lock();

           // 1. 判断
           while( number != 1){
               c1.await();
           }

           // 2. 干活
           for (int i = 0; i < 5; i++) {
               System.out.println(Thread.currentThread().getName() + "\t" + i);
           }

           // 3. 通知
           number = 2;
           c2.signal();


       }catch(Exception e){
           e.printStackTrace();
       }finally{
           lock.unlock();
       }
   }

    public void print10(){
        try {
            lock.lock();

            // 1. 判断
            while( number != 2){
                c2.await();
            }

            // 2. 干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            // 3. 通知
            number = 3;
            c3.signal();


        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void print15(){
        try {
            lock.lock();

            // 1. 判断
            while( number != 3){
                c3.await();
            }

            // 2. 干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            // 3. 通知
            number = 1;
            c1.signal();


        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }




}

public class SyncAndReentrantLockTest {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sharedResource.print5();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sharedResource.print10();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sharedResource.print15();
            }
        }, "C").start();

    }
}
