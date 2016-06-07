package com.zhengxin.pattern.singleton;

import java.util.Random;

/**
 * Created by 136931 on 2016/2/25.
 */
public enum Singleton {
    INSTANCE;

    private static final Random random = new Random();

    public void methodA(){
        System.out.println("Singleton : methodA");
    }

    public void methodB(){
        System.out.println("Singleton : methodB");
    }

    public static String generatePrimaryKey(){
        return String.valueOf(System.currentTimeMillis() * 1000 + random.nextInt(1000));
    }
}
