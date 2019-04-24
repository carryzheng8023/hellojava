package com.zhengxin.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhengxin on 18/1/19.
 * 列出File的一些常用操作，比如过滤、遍历等操作；
 */
public class FileUtils {

    /**
     * 列出指定目录下（包括其子目录）的所有文件
     */
    public static void listDir(File dir) throws IOException {

        if(!dir.exists()){
            throw new IllegalArgumentException("目录：" + dir + "不存在！" );
        }
        if(!dir.isDirectory()){
            throw new IllegalArgumentException(dir + "不是目录！" );
        }

//        String[] filenames = dir.list();
//        for (String filename : filenames){
//            System.out.println(filename);
//        }

        File[] files = dir.listFiles();

        if (null != files && files.length > 0){
            for (File file : files){

                if(file.isDirectory()){
                    listDir(file);
                }else {
                    System.out.println(file.getName());
                }
            }
        }



    }




}
