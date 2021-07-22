package xin.carryzheng.review;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhengxin
 * @date 2021-05-28 10:34:50
 */

class MyData {
    volatile int number = 0;

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addTo60() {
        this.number = 60;
    }

    public void addPlusPlus() {
        number++;
    }

    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }

}

public class VolatileTest {


    public static void main(String[] args) {


        /**
         * 不保证原子性
         * @author zhengxin
         * @date   2021/5/28 11:31
         */

        MyData myData = new MyData();

        for(int i=0; i<20; i++){
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t finally number value: " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t finally atomicInteger value: " + myData.atomicInteger);





        /**
         * 内存可见性
         *
         * @author zhengxin
         * @date   2021/5/28 11:31


        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myData.addTo60();

            System.out.println(Thread.currentThread().getName() + "\t updated number value: " + myData.number);
        }, "AAA").start();

        while (myData.number == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over");


        */
    }

}
