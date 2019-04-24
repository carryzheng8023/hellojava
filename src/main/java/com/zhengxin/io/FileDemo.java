package com.zhengxin.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by zhengxin on 18/1/19.
 */
public class FileDemo {

    public static void main(String[] args){

        File file = new File("/Users/zhengxin/Documents/GitProject/helloworld/src/main/java/com/zhengxin/io/test");

        System.out.println(file.exists());

        if(!file.exists()){
            file.mkdir();  //file.mkdirs();
        }else {
//            file.delete();
        }

        //是否是一个目录，如果是目录返回true，如果不是目录或目录不存在返回false
        System.out.println(file.isDirectory());
        //是否是一个文件
        System.out.println(file.isFile());


        File file2 = new File("/Users/zhengxin/Documents/GitProject/helloworld/src/main/java/com/zhengxin/io/日记.txt");
        if (!file2.exists()){
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
//            file2.delete();
        }

        //常见的File对象API
        System.out.println(file);//file.toString的内容
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getName());
        System.out.println(file2.getName());
        System.out.println(file.getParent());
        System.out.println(file2.getParent());



    }
}
