package com.zhengxin.j2se.io;//: io/MemoryInput.java

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("E:\\IntelliJ\\helloworld\\src\\main\\java\\com\\zhengxin\\j2se\\io\\MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1)
            System.out.print((char) c);
    }
} /* (Execute to see output) *///:~
