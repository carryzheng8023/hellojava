package xin.carryzheng.review;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zhengxin
 * @date 2021-05-31 16:53:48
 */
public class SemaphoreTest {


    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {

                try {
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName() + "\t抢到车位");

                    try { TimeUnit.SECONDS.sleep(3); }catch(InterruptedException e) { e.printStackTrace(); }

                    System.out.println(Thread.currentThread().getName() + "\t停车3秒后离开车位");


                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    semaphore.release();
                }

            }, String.valueOf(i)).start();
        }
    }

}
