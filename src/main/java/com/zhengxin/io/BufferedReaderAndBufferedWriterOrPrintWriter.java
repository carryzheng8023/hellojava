package com.zhengxin.io;

import java.io.*;

/**
 * Created by zhengxin on 18/1/20.
 */
public class BufferedReaderAndBufferedWriterOrPrintWriter {

    public static void main(String[] a)throws IOException{

        String baseDir = "/Users/zhengxin/Documents/GitProject/helloworld/src/main/java/com/zhengxin/io";

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(baseDir + "/日记.txt")));

        /**
         * BufferedReader + BufferedWriter
         * */
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(baseDir + "/日记1.txt")));
//        String line;
//        while((line = br.readLine()) != null){
//            System.out.println(line);
//            bw.write(line);
//            bw.newLine();
//            bw.flush();
//        }
//
//        br.close();
//        bw.close();

        /**
         * BufferedReader + PrintWriter
         * */
        PrintWriter pw = new PrintWriter(baseDir + "/日记1.txt");

        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
            pw.println(line);
            pw.flush();
        }


        br.close();
        pw.close();




    }
}
