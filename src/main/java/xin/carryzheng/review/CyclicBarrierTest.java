package xin.carryzheng.review;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author zhengxin
 * @date 2021-05-31 15:23:34
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {


        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println(Thread.currentThread().getName() + "\t召唤神龙！"));

        for (int i = 0; i < 7; i++) {

            final int tmpInt = i;

            new Thread(() -> {

                System.out.println(Thread.currentThread().getName() + "\t正在收集第" + tmpInt + "龙珠" );
                try {
                    cyclicBarrier.await();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }



    }
}
