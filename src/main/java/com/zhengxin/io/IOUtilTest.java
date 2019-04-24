package com.zhengxin.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhengxin on 18/1/19.
 */
public class IOUtilTest {

    public static void main(String[] a){

        String baseDir = "/Users/zhengxin/Documents/GitProject/helloworld/src/main/java/com/zhengxin/io";
//        try {
//            IOUtils.printHex("/Users/zhengxin/Documents/GitProject/helloworld/src/main/java/com/zhengxin/io/FileUtils.java");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            IOUtils.printHexByByteArray("/Users/zhengxin/Documents/GitProject/helloworld/src/main/java/com/zhengxin/io/FileUtils.java");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        try {
//            IOUtils.copyFile(new File(baseDir + "/日记.txt"), new File(baseDir + "/日记1.txt"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            IOUtils.copyFileByBuffer(new File(baseDir + "/日记.txt"), new File(baseDir + "/日记1.txt"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            IOUtils.copyFileByByte(new File(baseDir + "/日记.txt"), new File(baseDir + "/日记1.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
