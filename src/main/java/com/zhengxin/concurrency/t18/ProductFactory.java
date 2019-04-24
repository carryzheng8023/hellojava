package com.zhengxin.concurrency.t18;

import java.util.Random;

/**
 * @author zhengxin
 * @date 2018-02-06 18:38:04
 */
public class ProductFactory {


    public Future createProduct(String name){

        Future f = new Future();//创建一个订单
        System.out.println("下单成功，你可以去上班了");

        //生产产品

        new Thread(()->{
            Product p = new Product(new Random().nextInt(), name);

            f.setProduct(p);

        }).start();



        return f;


    }

}
