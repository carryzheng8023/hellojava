package xin.carryzheng.review;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhengxin
 * @date 2021-05-28 17:31:03
 */

class Phone implements Runnable{
    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getName() + "\t invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "\t invoked sendEmail()");
    }

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    public void get(){

        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked get()");
            set();
        }finally {
            lock.unlock();
            lock.unlock();
        }

    }

    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked set()");
        }finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockTest {

    public static void main(String[] args) {
        Phone p = new Phone();

        new Thread(p::sendSMS, "t1").start();
        new Thread(p::sendSMS, "t2").start();

        try { TimeUnit.SECONDS.sleep(1); }catch(InterruptedException e) { e.printStackTrace(); }

        System.out.println("========================================");

        Thread t3 = new Thread(p, "t3");
        Thread t4 = new Thread(p, "t4");

        t3.start();
        t4.start();
    }

}
