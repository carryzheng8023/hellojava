package com.zhengxin.j2se.io;//: io/LargeMappedFiles.java
// Creating a very large file using mapping.
// {RunByHand}

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import static com.zhengxin.j2se.net.mindview.util.Print.*;

public class LargeMappedFiles {
    static int length = 0x8FFFFFF; // 128 MB

    public static void main(String[] args) throws Exception {
        MappedByteBuffer out = new RandomAccessFile("E:\\IntelliJ\\helloworld\\src\\main\\java\\com\\zhengxin\\j2se\\io\\test.dat", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++)
            out.put((byte) 'x');
        print("Finished writing");
        for (int i = length / 2; i < length / 2 + 6; i++)
            printnb((char) out.get(i));
//        for (int i = 0; i < length; i++)
//            printnb((char) out.get(i));
    }
} ///:~
