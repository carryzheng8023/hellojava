package com.zhengxin.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhengxin on 18/1/23.
 */
public class Main {

    public static void main(String[] a){

//        List<A> l = new ArrayList<>();
//        while (true){
//            l.add(new A());
//        }

//        byte[] b1 = new byte[7 * 1024 * 1024];
//        byte[] b2 = new byte[2 * 1024 * 1024];
//        byte[] b3 = new byte[2 * 1024 * 1024];
//        byte[] b4 = new byte[4 * 1024 * 1024];

//        System.gc();


//        Map<Thread, StackTraceElement[]> m = Thread.getAllStackTraces();
//        for(Map.Entry<Thread, StackTraceElement[]> en : m.entrySet()){
//            Thread t = en.getKey();
//            StackTraceElement[] v = en.getValue();
//
//            System.out.println("Thread name is: " + t.getName());
//            for (StackTraceElement s : v){
//                System.out.println("\t" + s.toString());
//            }
//        }

        Object o1 = new Object();
        Object o2 = new Object();

        new Thread(new DeadLock(o1, o2)).start();
        new Thread(new DeadLock(o2, o1)).start();

    }

}
