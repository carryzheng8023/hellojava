package xin.carryzheng.review;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author zhengxin
 * @date 2021-06-08 10:27:51
 */

class MyRunnable implements Runnable {

    @Override
    public void run() {

    }
}

class MyCallable implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {

        System.out.println(Thread.currentThread().getName() + "\tMyCallable call invoked！");

        try { TimeUnit.SECONDS.sleep(2); }catch(InterruptedException e) { e.printStackTrace(); }

        return 2048;
    }
}

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());



        new Thread(futureTask, "AA").start();

//        while (!futureTask.isDone()){
//
//        }
        int result = futureTask.get();


        System.out.println(Thread.currentThread().getName() + "\t result + 100：" + (result + 100));


    }


}
