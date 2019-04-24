package com.zhengxin.db;

import java.sql.Blob;

/**
 * @author zhengxin
 * @date 2018-06-22 11:39:38
 */
public class Student {

    private Integer stuId;
    private String name;
    private Integer age;

    public Student(){}

    public Student(Integer stuId, String name, Integer age) {
        this.stuId = stuId;
        this.name = name;
        this.age = age;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
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



    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
