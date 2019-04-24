package com.zhengxin.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zhengxin on 18/1/20.
 */
public class DataOutputStreamDemo {

    public static void main(String[] a) throws IOException{

        String baseDir = "/Users/zhengxin/Documents/GitProject/helloworld/src/main/java/com/zhengxin/io";

        String file = baseDir + "/dos.dat";

        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));

        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(10L);
        dos.writeDouble(10.5);
        dos.writeUTF("中国");//采用utf8编码写出
        dos.writeChars("中国");//采用utf16be编码写出
        dos.close();
        IOUtils.printHex(file);
    }

}
