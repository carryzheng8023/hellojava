package com.zhengxin.java8.lambda;

/**
 * @author zhengxin
 * @date 2018-05-05 14:38:56
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 *
 * Supplier<T> : 供给型接口
 * 		T get();
 *
 * Function<T, R> : 函数型接口
 * 		R apply(T t);
 *
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 *
 */
public class TestLambda3 {

    //Consumer<T> 消费型接口
    @Test
    public void test1(){

        happy(10000, x -> System.out.println("消费" + x + "元"));

    }

    private void happy(double money, Consumer<Double> consumer){
        consumer.accept(money);

    }

    //Supplier<T> : 供给型接口
    @Test
    public void test2(){

        List<Integer> list = getNumList(10, () -> (int)(Math.random() * 100));
        list.forEach(System.out::println);

    }

    private List<Integer> getNumList(int num, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<num; i++){
            list.add(supplier.get());
        }

        return list;
    }

    //Function<T, R> : 函数型接口
    @Test
    public void test3(){

        System.out.println(strhandle("hello", str -> str.toUpperCase()));

    }

    private String strhandle(String str, Function<String, String> fun){
        return fun.apply(str);
    }

    //Predicate<T> : 断言型接口
    @Test
    public void test4(){

        List<String> list = Arrays.asList("hello", "app", "lambda", "hi", "apple");

        filterStr(list, (str) -> str.length() > 3).forEach(System.out::println);
    }

    private List<String> filterStr(List<String> list, Predicate<String> pre){

        List<String> strList = new ArrayList<>();
        for (String str : list){
            if(pre.test(str))
                strList.add(str);
        }

        return strList;
    }

}
