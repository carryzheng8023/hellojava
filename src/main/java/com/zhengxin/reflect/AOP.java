package com.zhengxin.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhengxin
 * @date 2018-06-27 09:12:25
 */


interface Subject{

    int f1(String s);
    double f2(String s);
    static void f3(){
        System.out.println("我是静态方法");
    }

    default void f4(){
        System.out.println("我是默认方法");
    }

}

//被代理类
class RealSubject implements Subject{

    @Override
    public int f1(String s) {
        System.out.println("传入的整型数字是："  + s);
        return Integer.parseInt(s);
    }
    @Override
    public double f2(String s) {
        System.out.println("传入的浮点数字是："  + s);
        return Double.parseDouble(s);
    }

    @Override
    public void f4() {
        System.out.println("我是默认方法的实现");
    }
}




//class IH<T> implements InvocationHandler{
//
//    private T object = null;
//
//    public void setObj(T object){
//        this.object = object;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//        LogUtil.before(method.getName());
//
//        Object o = method.invoke(this.object, args);
//
//        LogUtil.after(method.getName());
//
//        return o;
//
//    }
//
//}


public class AOP {

    public static void main(String[] args){

        Subject s = MyProxy.getProxyInstance(new RealSubject());
        System.out.println(s.f1("1"));
        System.out.println(s.f2("23.4"));
//        s.f3();
        s.f4();

    }



}
