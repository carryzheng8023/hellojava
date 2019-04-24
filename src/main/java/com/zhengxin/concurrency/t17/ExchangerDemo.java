package com.zhengxin.concurrency.t17;

import java.util.concurrent.Exchanger;

/**
 * @author zhengxin
 * @date 2018-02-04 21:44:15
 */
public class ExchangerDemo {


    public void a(Exchanger<String> exchanger){


        System.out.println("a开始抓取数据...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("a抓取数据完成...");

        String res = "222";

        try {
            System.out.println("a等待比对结果...");
//            exchanger.exchange(res);
            exchanger.exchange("333");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void b(Exchanger<String> exchanger){


        System.out.println("b开始抓取数据...");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("b抓取数据完成...");

        String res = "222";

        try {
            String val = exchanger.exchange(res);
            System.out.println("开始进行比对...");
            System.out.println("比对结果：" + val.equals(res));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] a){

        Exchanger<String> exchanger = new Exchanger<>();

        ExchangerDemo exchangerDemo = new ExchangerDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                exchangerDemo.a(exchanger);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                exchangerDemo.b(exchanger);
            }
        }).start();

    }
}
