package com.zhengxin;

/**
 * Created by zhengxin on 18/1/16.
 */
public class DemoHolder {

    private static final ThreadLocal<String> holder = new ThreadLocal<>();

    public static String get(){
        return holder.get() == null ? "unknown" : holder.get();
    }

    public static void set(String user){
        holder.set(user);
    }
}
