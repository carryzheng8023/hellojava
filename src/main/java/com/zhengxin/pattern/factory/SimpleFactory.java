package com.zhengxin.pattern.factory;

/**
 * Created by 136931 on 2016/2/23.
 */
public class SimpleFactory {

    public static LeiFeng createLeiFeng(String type){

        LeiFeng result = null;

        switch (type){
            case "大学生"  : result = new Undergraduate(); break;
            case "志愿者"  : result = new Volunteer(); break;
            default :
        }

        return result;

    }

}
