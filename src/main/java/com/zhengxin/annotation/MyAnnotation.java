package com.zhengxin.annotation;

/**
 * @author zhengxin
 * @date 2018-06-27 14:17:48
 */
public @interface MyAnnotation {

    String value() default "hello";
}
