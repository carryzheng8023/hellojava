package com.zhengxin.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengxin on 18/1/23.
 */
public class JConsoleTest {


    public byte[] b1 = new byte[10 * 1024 * 1024];


    public static void main(String[] a){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("start...");

        fill(1000);

    }

    private static void fill(int n){
        List<JConsoleTest> jList = new ArrayList<>();

        for (int i=0; i<n; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            jList.add(new JConsoleTest());
        }
    }


}
