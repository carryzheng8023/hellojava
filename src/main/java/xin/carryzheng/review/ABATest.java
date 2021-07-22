package xin.carryzheng.review;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 *  解决ABA问题  AtomicStampedReference
 * @author zhengxin
 * @date 2021-05-28 14:49:57
 */
public class ABATest {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {


        System.out.println("==================以下是ABA问题产生==================");

        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();


        new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(1); }catch(InterruptedException e) { e.printStackTrace(); }

            System.out.println(Thread.currentThread().getName() + "\t是否修改成功：" + atomicReference.compareAndSet(100, 2021) + "\t" + atomicReference.get());

        }, "t2").start();






        System.out.println("==================以下是ABA问题解决方案==================");

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t第1次版本号: " + stamp);

            try { TimeUnit.SECONDS.sleep(1); }catch(InterruptedException e) { e.printStackTrace(); }

            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() + "\t第2次版本号: " + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() + "\t第3次版本号: " + atomicStampedReference.getStamp());

        }, "t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t第1次版本号: " + stamp);

            try { TimeUnit.SECONDS.sleep(3); }catch(InterruptedException e) { e.printStackTrace(); }

            boolean res = atomicStampedReference.compareAndSet(100, 2021, stamp, stamp+1);

            System.out.println(Thread.currentThread().getName() + "\t是否修改成功：" + res + "\t当前最新实际版本号：" + atomicStampedReference.getStamp());

            System.out.println(Thread.currentThread().getName() + "\t当前实际最新值：" + atomicStampedReference.getReference());

        }, "t4").start();

    }
}
