package xin.carryzheng.review;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author zhengxin
 * @date 2021-05-31 15:11:45
 */
public class CountDownLatchTest {


    public static void main(String[] args) throws Exception{

        CountDownLatch count = new CountDownLatch(6);


        for (int i = 1; i < 7; i++) {

            new Thread(() -> {

                try { TimeUnit.SECONDS.sleep(1); }catch(InterruptedException e) { e.printStackTrace(); }

                System.out.println(Thread.currentThread().getName() + "\t已完成！");

                count.countDown();
            }, CountryEnum.forEach_Country(i).getMessage()).start();
        }


        count.await();
        System.out.println("秦" + "\t#############已完成！");
    }

}
