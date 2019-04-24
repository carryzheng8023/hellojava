package com.zhengxin.java8.concurrent;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zhengxin
 * @date 2018-05-06 15:23:27
 */
public class TestSimpleDateFormat {

    public static void main(String[] args) throws Exception{

        /*旧

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> task = () -> DateFormatThreadLocal.convert("20180506");

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> result = new ArrayList<>();

        for(int i=0; i<10; ++i)
            result.add(pool.submit(task));


        for (Future<Date> future : result)
            System.out.println(future.get());

        pool.shutdown();

        */

       /**
        * java8
        * */

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

        Callable<LocalDate> task = () -> LocalDate.parse("20180506", dtf);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<LocalDate>> result = new ArrayList<>();

        for(int i=0; i<10; ++i)
            result.add(pool.submit(task));


        for (Future<LocalDate> future : result)
            System.out.println(future.get());

        pool.shutdown();
    }
}
