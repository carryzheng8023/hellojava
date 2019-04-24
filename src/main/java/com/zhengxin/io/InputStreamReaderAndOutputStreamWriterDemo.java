package com.zhengxin.io;

import java.io.*;

/**
 * Created by zhengxin on 18/1/20.
 */
public class InputStreamReaderAndOutputStreamWriterDemo {


    public static void main(String[] a) throws IOException{

        String baseDir = "/Users/zhengxin/Documents/GitProject/helloworld/src/main/java/com/zhengxin/io";

        InputStreamReader isr = new InputStreamReader(new FileInputStream(baseDir + "/日记.txt"), "utf-8");

//        int c;
//        while ((c = isr.read()) != -1){
//            System.out.print((char)c);
//        }

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(baseDir + "/日记1.txt"), "utf-8");

        char[] buf = new char[8 * 1024];
        int bytes;
        while ((bytes = isr.read(buf, 0, buf.length)) != -1){

//            for (int i=0; i<bytes; i++){
//                System.out.print(buf[i]);
//
//            }
            String s = new String(buf,0,bytes);
            System.out.print(s);
            osw.write(buf, 0, bytes);
            osw.flush();


        }

        isr.close();
        osw.close();

    }

}
