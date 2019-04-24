package com.zhengxin.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by zhengxin on 18/1/20.
 */
public class FileReaderAndFileWriterDemo {

    public static void main(String[] a)throws IOException{


        String baseDir = "/Users/zhengxin/Documents/GitProject/helloworld/src/main/java/com/zhengxin/io";

        FileReader fr = new FileReader(baseDir + "/日记.txt");
        FileWriter fw = new FileWriter(baseDir + "/日记1.txt");
        /*true会追加，而不是删除重新写*/
//        FileWriter fw = new FileWriter(baseDir + "/日记1.txt", true);

        char[] buf = new char[8 * 1024];

        int c;

        while((c = fr.read(buf, 0, buf.length)) != -1){
            fw.write(buf, 0, c);
            fw.flush();
        }

        fr.close();
        fw.close();


    }

}
