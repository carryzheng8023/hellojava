package com.zhengxin.io;

import com.zhengxin.B;

import java.io.*;

/**
 * Created by zhengxin on 18/1/20.
 */
public class ObjectSerializedDemo {

    public static void main(String[] a) throws Exception{
        String baseDir = "/Users/zhengxin/Documents/GitProject/helloworld/src/main/java/com/zhengxin/io";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(baseDir + "/obj.dat"));

        Student student = new Student(1L,"张三", 22,new B("BJUT", "平乐园100号"));
        oos.writeObject(student);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(baseDir + "/obj.dat"));
        Student s = (Student)ois.readObject();
        System.out.println(s);
        ois.close();

        System.out.println(student.getB() == s.getB());

        student.getB().setAddress("西大望路27号");

        System.out.println(student);
        System.out.println(s);


    }

}
