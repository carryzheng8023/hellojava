package com.zhengxin.pattern.singleton;

import java.io.IOException;
import java.util.Properties;

/**
 * @author zhengxin
 * @date 2019-03-18 22:17:38
 */
public class Singleton3 {

    private String info;

    public static final Singleton3 INSTANCE;

    static {
        Properties prop = new Properties();

        try {
            prop.load(Singleton3.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        INSTANCE = new Singleton3(prop.getProperty("username"));
    }

    private Singleton3(String info){
        this.info = info;
    }

    public void f(){
        System.out.println("Singleton3:" + this.info);
    }




}
