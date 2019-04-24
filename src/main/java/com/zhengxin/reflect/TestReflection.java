package com.zhengxin.reflect;

import org.junit.Test;

/**
 * @author zhengxin
 * @date 2018-06-26 14:45:28
 */
public class TestReflection {


    @Test
    public void test(){

        Class c1 = TestReflection.class;

        TestReflection testReflection = new TestReflection();

        Class c2 = testReflection.getClass();

        System.out.println(c1);

        System.out.println(c1 == c2);


    }

}
