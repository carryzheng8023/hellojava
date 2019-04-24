package com.zhengxin.annotation;

import java.time.Period;

/**
 * @author zhengxin
 * @date 2018-06-27 14:04:55
 */
public class TestAnnotation {
}


@MyAnnotation
class Student extends Person{

    @Override
    public void walk(){
        System.out.println("学生走路");
    }

    @Override
    public void eat(){
        System.out.println("学生吃饭");
    }

}

class Person{

    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk(){
        System.out.println("走路");
    }

    public void eat(){
        System.out.println("吃饭");
    }

}
