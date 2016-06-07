package com.zhengxin;

/**
 * Created by 136931 on 2016/2/26.
 */
public class A {

    private String name;
    private Integer age;
    private String url;

    public A(){}

    public A(String name, Integer age, String url){
        this.name = name;
        this.age = age;
        this.url =url;
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
    public String toString(){
        return "name: " + this.name + ",age: " + this.age + ",url: " + this.url;
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
