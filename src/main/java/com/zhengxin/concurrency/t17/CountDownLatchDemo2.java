package com.zhengxin.concurrency.t17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhengxin
 * @date 2018-02-04 16:00:14
 */
public class CountDownLatchDemo2 {


    private final static String baseDir = "/Users/zhengxin/Documents/GitProject/helloworld/src/main/java/com/zhengxin/concurrency/t17";

    private int[] nums;

    public CountDownLatchDemo2(int line){

        nums = new int[line];
    }

    public void calc(String line, int index, CountDownLatch countDownLatch){

        String[] nus = line.split(",");

        int total = 0;

        for (String num : nus){
            total += Integer.parseInt(num);
        }

        nums[index] = total;

        System.out.println(Thread.currentThread().getName() + " 执行计算任务..." + line + " 结果为：" + total);

        countDownLatch.countDown();
    }

    public void sum(){

        System.out.println("汇总线程开始执行...");

        int total = 0;

        for(int num : nums){
            total += num;
        }
        System.out.println("最终的结果为：" + total);
    }

    public static void main(String[] a){

        List<String> contents = readFile();

        int lineCount = contents.size();

        CountDownLatch countDownLatch = new CountDownLatch(lineCount);

        CountDownLatchDemo2 cdl = new CountDownLatchDemo2(lineCount);

        for (int i=0; i<lineCount; i++){
            final int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cdl.calc(contents.get(j), j, countDownLatch);
                }
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        cdl.sum();

    }

    private static List<String> readFile() {

        List<String> contents = new ArrayList<>();
        String line = null;

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(baseDir + "/num.txt"));

            while (null != (line = br.readLine())){
                contents.add(line);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }



        return contents;
    }


}
