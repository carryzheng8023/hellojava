package com.zhengxin.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by zhengxin on 18/1/20.
 */
public class DataInputStreamDemo {

    public static void main(String[] a) throws IOException{

        String baseDir = "/Users/zhengxin/Documents/GitProject/helloworld/src/main/java/com/zhengxin/io";

        String file = baseDir + "/dos.dat";

        IOUtils.printHex(file);

        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        int i = dis.readInt();
        System.out.println(i);
        i = dis.readInt();
        System.out.println(i);

        long l = dis.readLong();
        System.out.println(l);

        double d = dis.readDouble();
        System.out.println(d);

        String s = dis.readUTF();
        System.out.println(s);

        dis.close();




    }

}
