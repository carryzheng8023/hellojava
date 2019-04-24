package com.zhengxin.java8.lambda;

/**
 * @author zhengxin
 * @date 2018-05-05 13:30:39
 */

@FunctionalInterface
public interface MyPredicate<T> {

    boolean test(T t);
}
