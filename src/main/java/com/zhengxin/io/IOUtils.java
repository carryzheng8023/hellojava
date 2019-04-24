package com.zhengxin.io;

import com.zhengxin.algorithm.alg4.utils.In;

import java.io.*;

/**
 * Created by zhengxin on 18/1/19.
 */
public class IOUtils {

    /**
     * 读取指定文件内容，按照16进制输出到控制台
     * 并且输出10个byte换行
     * @param filename
     * */
    public static void printHex(String filename) throws IOException{

        //将文件作为字节流进行读操作
        FileInputStream in = new FileInputStream(filename);
        int b;
        int i = 1;
        while ((b = in.read()) != -1){

            if (b <= 0xf){
                //单位数前补0
                System.out.print("0");
            }

            System.out.print(Integer.toHexString(b & 0xff) + " ");
            if(i++ % 10 == 0){
                System.out.println();
            }
        }
        in.close();

    }

    public static void printHexByByteArray(String filename) throws IOException{

        FileInputStream in = new FileInputStream(filename);

        /**从in中批量读取字节，放到buf这个字节数组中，
         * 从第0个位置开始放，最多放buf.length个，
         * 返回的是读到的字节的个数
         * */
        byte[] buf = new byte[8 * 1024];
//        int bytes = in.read(buf, 0, buf.length);//y一次性读完，说明字节数组足够大
//
//        int j = 1;
//
//        for (int i=0; i<bytes; i++){
//            if (buf[i] <= 0xf){
//                //单位数前补0
//                System.out.print("0");
//            }
//            System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
//
//            if(j++ % 10 == 0){
//                System.out.println();
//            }
//        }

        int bytes = 0;
        int j = 1;
        while ((bytes = in.read(buf, 0, buf.length)) != -1){

            for (int i=0; i<bytes; i++){
//                  if (buf[i] <= 0xf){
//                //单位数前补0
//                System.out.print("0");
//              }
                System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");

                if(j++ % 10 == 0){
                System.out.println();
                }
             }
        }

        in.close();

    }

    /**
     * 文件拷贝，字节批量读取
     * 最快！！！
     * */
    public static void copyFile(File src, File dest) throws IOException{

        if(!src.exists()){
            throw new IllegalArgumentException("文件：" + src +"不存在！");
        }

        if(!src.isFile()){
            throw new IllegalArgumentException(src +"不是文件！");
        }

        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dest);

        byte[] buf = new byte[8 * 1024];

        int b;

        while ((b = in.read(buf,0, buf.length)) != -1){

            out.write(buf,0, b);
            out.flush();

        }

        in.close();
        out.close();


    }


    /**
     * 带有缓冲区的文件拷贝
     * */
    public static void copyFileByBuffer(File src, File dest)throws IOException{

        if(!src.exists()){
            throw new IllegalArgumentException("文件：" + src +"不存在！");
        }

        if(!src.isFile()){
            throw new IllegalArgumentException(src +"不是文件！");
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));

        int b;

        while ((b = bis.read()) != -1){
            bos.write(b);
            bos.flush();
        }

        bis.close();
        bos.close();

    }

    /**
     * 单字节，不带缓冲进行文件拷贝
     * */
    public static void copyFileByByte(File src, File dest)throws IOException{

        if(!src.exists()){
            throw new IllegalArgumentException("文件：" + src +"不存在！");
        }

        if(!src.isFile()){
            throw new IllegalArgumentException(src +"不是文件！");
        }

        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dest);

        int c;

        while((c = in.read()) != -1){
            out.write(c);
            out.flush();
        }

        in.close();
        out.close();

    }


}
