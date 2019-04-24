package com.zhengxin.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by zhengxin on 18/1/19.
 */
public class RafDemo {


    public static void main(String[] a) throws IOException{

        File demo = new File("/Users/zhengxin/Documents/GitProject/helloworld/src/main/java/com/zhengxin/io/demo");
        if(!demo.exists()){
            demo.mkdir();
        }
        File file = new File(demo, "raf.dat");
        if(!file.exists()){
            file.createNewFile();
        }else {
            file.delete();
            file.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");

        //指针位置
        System.out.println(raf.getFilePointer());

        raf.write('A');//只写了一个字节
        System.out.println(raf.getFilePointer());


        raf.write('B');

        int i = 0x7fffffff;

        /**
         * 1个字节=2位
         * */
        //用write方法每次只能写一个字节，如果把i写进去就得写4次
        raf.write(i >>> 24);//高八位
        raf.write(i >>> 16);
        raf.write(i >>> 8);
        raf.write(i >>> 0);
        System.out.println(raf.getFilePointer());

        //可以直接写一个int
        raf.writeInt(i);

        String s = "中";
        byte[] gbk = s.getBytes("utf-8");
        raf.write(gbk);

        System.out.println(raf.getFilePointer());
        System.out.println(raf.length());


        //读文件 ，必须把指针移到头部
        raf.seek(0);
        //一次性读取，把文件内容都读到字节数组中
        byte[] buf = new byte[(int)raf.length()];
        raf.read(buf);
        System.out.println(Arrays.toString(buf));

       for (byte b : buf){
           System.out.print(Integer.toHexString(b & 0xff) + " ");
       }

       raf.close();




    }


}
