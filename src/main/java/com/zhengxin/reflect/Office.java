package com.zhengxin.reflect;

/**
 * Created by zhengxin on 18/1/23.
 */
public class Office {

    public static void main(String[] a){

        Class c = null;
        try {
            c = Class.forName(a[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        OfficeAble oa = null;
        try {
            oa = (OfficeAble)c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        oa.start();

    }
}
