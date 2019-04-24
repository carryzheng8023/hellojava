package com.zhengxin.reflect;

/**
 * @author zhengxin
 * @date 2018-06-27 10:25:04
 */
public class LogUtil {

        public static void before(String methodName){

            System.out.println(methodName + "方法调用开始...");
        }

        public static void after(String methodName){
            System.out.println(methodName + "方法调用结束...");
        }

}
