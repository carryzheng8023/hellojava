package com.zhengxin.j2se.io;//: io/FreezeAlien.java
// Create a serialized output file.

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class FreezeAlien {
    public static void main(String[] args) throws Exception {
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("E:\\IntelliJ\\helloworld\\src\\main\\java\\com\\zhengxin\\j2se\\io\\X.file"));
        Alien quellek = new Alien();
        out.writeObject(quellek);
    }
} ///:~
