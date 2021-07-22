package xin.carryzheng.review;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zhengxin
 * @date 2021-05-31 17:00:23
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws Exception{

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        /**
         * add remove
         * @author zhengxin
         * @date   2021/5/31 18:16
         */

//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//
//        System.out.println(blockingQueue.element());
//
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());



        /**
         * offer poll
         * @author zhengxin
         * @date   2021/5/31 18:17
         */

//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("x"));
//
//        System.out.println(blockingQueue.peek());
//
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());


        /**
         * put take
         * @author zhengxin
         * @date   2021/5/31 18:17
         */
//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
////        blockingQueue.put("x");
//
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();
////        blockingQueue.take();

        BlockingQueue<String> queue = new SynchronousQueue<>();

        new Thread(() -> {

            try {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                queue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put 2");
                queue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put 3");
                queue.put("3");
            }catch(Exception e){
                e.printStackTrace();
            }

        }, "AAA").start();

        new Thread(() -> {

            try {
                try { TimeUnit.SECONDS.sleep(5); }catch(InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + "\t" + queue.take());
                try { TimeUnit.SECONDS.sleep(5); }catch(InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + "\t" + queue.take());
                try { TimeUnit.SECONDS.sleep(5); }catch(InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + "\t" + queue.take());
            }catch(Exception e){
                e.printStackTrace();
            }

        }, "BBB").start();




    }
}
