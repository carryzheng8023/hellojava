package com.zhengxin.io;


import com.zhengxin.B;
import com.zhengxin.algorithm.alg4.utils.In;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by zhengxin on 18/1/20.
 */
public class Student implements Serializable {

    private Long studentId;
    private String name;
    private transient Integer age; //该元素不会被jvm默认的序列化,也可以自己完成序列化
    private B b;

    public Student(){

    }

    public Student(Long studentId, String name, Integer age, B b) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.b = b;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", b=" + b +
                '}';
    }

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException{

        s.defaultWriteObject();//把jvm能默认序列化的元素进行序列化操作
        s.writeObject(age);//自己完成age的序列化
    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {


        s.defaultReadObject();//把jvm能默认反序列化的进行反序列化操作
        this.age = (Integer) s.readObject();//自己完成age的反序列化操作

    }
}
