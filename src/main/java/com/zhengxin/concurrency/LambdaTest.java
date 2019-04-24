package com.zhengxin.concurrency;


import java.util.Arrays;
import java.util.List;

/**
 * Created by zhengxin on 18/1/24.
 */
public class LambdaTest {

    public static void main(String[] a){
        List<Integer> values = Arrays.asList(10, 20, 30, 40);

        int res = new LambdaTest().add(values);

        System.out.println("计算结果: " + res);
    }


    public int add(List<Integer> values){

        return values.parallelStream()
                .mapToInt(a -> a)
                .sum();

    }

}
