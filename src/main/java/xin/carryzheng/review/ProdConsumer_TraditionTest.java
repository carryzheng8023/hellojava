package xin.carryzheng.review;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhengxin
 * @date 2021-06-03 10:02:29
 */
class SharedData{
    private int number = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void increase(){

        try {
            lock.lock();

            //1 判断
            while (number != 0){
                // 等待不能生产
                condition.await();
            }

            //2 干活
            this.number ++;


            //3 通知唤醒
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }

    public void decrease(){

        try {
            lock.lock();

            //1 判断
            while (number == 0){
                // 等待不能生产
                condition.await();
            }

            //2 干活
            this.number --;

            //3 通知唤醒
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }
}

public class ProdConsumer_TraditionTest {

    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedData.increase();
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedData.decrease();
            }
        }, "BBB").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedData.increase();
            }
        }, "CCC").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedData.decrease();
            }
        }, "DDD").start();
    }

}
