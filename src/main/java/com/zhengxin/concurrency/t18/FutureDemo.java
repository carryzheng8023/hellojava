package com.zhengxin.concurrency.t18;

/**
 * @author zhengxin
 * @date 2018-02-06 18:41:36
 */
public class FutureDemo {


    public static void main(String[] a){

        ProductFactory pf = new ProductFactory();

        //下单、交钱
        Future future = pf.createProduct("蛋糕");

        System.out.println("我去上班了，下了班我来取蛋糕");

        //拿着订单获取产品
        System.out.println("我拿着蛋糕回家 " + future.getProduct());


    }

}
