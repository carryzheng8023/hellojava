package com.zhengxin.java8.concurrent;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhengxin
 * @date 2018-05-06 15:32:53
 */
public class DateFormatThreadLocal {

//    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
//        protected DateFormat initialValue() {
//            return new SimpleDateFormat("yyyyMMdd");
//        }
//    };

    private static final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));

    public static Date convert(String source) throws ParseException {
        return df.get().parse(source);
    }


}
