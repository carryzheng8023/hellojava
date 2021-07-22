package xin.carryzheng.review;


import java.util.concurrent.*;

/**
 * @author zhengxin
 * @date 2021-06-08 13:32:39
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());

//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newCachedThreadPool();
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());


        try {

            for (int i = 0; i < 15; i++) {
                threadPool.execute(() -> {

                    System.out.println(Thread.currentThread().getName() + "\t 办理业务" );

                   try { TimeUnit.MILLISECONDS.sleep(200); }catch(InterruptedException e) { e.printStackTrace(); }

                });

            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }

    }
}
