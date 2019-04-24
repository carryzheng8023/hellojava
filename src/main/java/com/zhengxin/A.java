package com.zhengxin;

/**
 * Created by 136931 on 2016/2/26.
 */
public class A implements Cloneable{

    private String name;
    private Integer age;
    private String url;
    private B b;

    public A(){}

    public A(String name, Integer age, String url, B b) {
        this.name = name;
        this.age = age;
        this.url = url;
        this.b = b;
    }

    //    public void aMethod(){
//
//        Inner inner = new Inner();
//
//        Thread thread = new Thread(inner);
//
//        thread.start();
//
//    }


    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", url='" + url + '\'' +
                ", b=" + b +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    protected A clone() throws CloneNotSupportedException {
        return (A)super.clone();
    }


    //    class Inner implements Runnable{
//
//        public Inner(){}
//
//        @Override
//        public void run(){
//            this.innerMethod();
//        }
//
//        public void innerMethod(){
//            System.out.println("inner method invoked!");
//        }
//
//    }
}
