package xin.carryzheng.review;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * @author zhengxin
 * @date 2021-05-29 13:22:59
 */
public class SpinLockTest {

    // 原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){
        Thread thread = Thread.currentThread();

        while (!atomicReference.compareAndSet(null, thread)){

        }

        System.out.println(thread.getName() + "\t lock invoked!");
    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t unlock invoked!");
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) {

        SpinLockTest lock = new SpinLockTest();

        new Thread(() -> {
            lock.lock();
            try { TimeUnit.SECONDS.sleep(5); }catch(InterruptedException e) { e.printStackTrace(); }
            lock.unlock();
        }, "AAA").start();

        try { TimeUnit.SECONDS.sleep(1); }catch(InterruptedException e) { e.printStackTrace(); }

        new Thread(() -> {
            lock.lock();
            lock.unlock();
            try { TimeUnit.SECONDS.sleep(5); }catch(InterruptedException e) { e.printStackTrace(); }
        }, "BBB").start();

    }
}
