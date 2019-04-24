package com.zhengxin.java8.interfac;

/**
 * @author zhengxin
 * @date 2018-05-06 15:02:42
 */
public interface MyInterface {

    default String getName(String name){
        return "MyInterface " + name;
    }

    static void show(){
        System.out.println("接口中的静态方法");
    }

}
