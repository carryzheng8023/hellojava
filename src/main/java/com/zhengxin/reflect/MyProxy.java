package com.zhengxin.reflect;

import java.lang.reflect.Proxy;

/**
 * @author zhengxin
 * @date 2018-06-27 10:21:44
 */
public class MyProxy {

    @SuppressWarnings("unchecked")
    public static <T> T getProxyInstance(T obj) {

        return (T)Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), (proxy, method, args) -> {

            LogUtil.before(method.getName());

            Object o = method.invoke(obj, args);

            LogUtil.after(method.getName());

            return o;

        });

    }
}
