package com.zhengxin.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zhengxin on 18/1/20.
 */
public class FileOutputDemo {

    public static void main(String[] a) throws IOException{

        String baseDir = "/Users/zhengxin/Documents/GitProject/helloworld/src/main/java/com/zhengxin/io";

        //如果该文件不存在，则直接创建，如果该文件存在，则删除后创建
        FileOutputStream out = new FileOutputStream(baseDir + "/out.dat");

        out.write('A');//写出了A字符的低8位
        out.write('B');//写出了B字符的低8位

        int a1 = 10; //write只能写8位，那么写一个int需要写4次，每次写八位
        out.write(a1 >> 24);
        out.write(a1 >> 16);
        out.write(a1 >> 8);
        out.write(a1 >> 0);

        byte[] utf8 = "中国".getBytes("gbk");
        out.write(utf8);
        out.close();

        IOUtils.printHex(baseDir + "/out.dat");

    }
}
