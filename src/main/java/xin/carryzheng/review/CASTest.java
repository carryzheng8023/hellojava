package xin.carryzheng.review;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhengxin
 * @date 2021-05-28 11:58:01
 */
public class CASTest {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);


        System.out.println(atomicInteger.compareAndSet(5, 2021) + "\t current data: " + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data: " + atomicInteger.get());
    }
}