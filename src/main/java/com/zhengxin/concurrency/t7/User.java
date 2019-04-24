package com.zhengxin.concurrency.t7;

/**
 * @author zhengxin
 * @date 2018-01-26 17:27:20
 */
public class User {

    private String name;
    public volatile int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
