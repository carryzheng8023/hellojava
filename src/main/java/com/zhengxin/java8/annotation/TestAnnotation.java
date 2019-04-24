package com.zhengxin.java8.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhengxin
 * @date 2018-05-06 19:30:57
 */
public class TestAnnotation {


    @Test
    public void test1() throws Exception{
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method method = clazz.getMethod("show", String.class, Integer.class);
        MyAnnotation[] mas = method.getAnnotationsByType(MyAnnotation.class);
        new ArrayList<>(Arrays.asList(mas)).forEach(System.out::println);

    }


    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(@MyAnnotation("abc") String str, Integer i){}

}
