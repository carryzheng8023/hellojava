package com.zhengxin.io;

/**
 * Created by zhengxin on 18/1/19.
 */
public class EncodeDemo {

    public static void main(String[] args) throws Exception{

        String s = "联通";
        byte[] byte1 = s.getBytes("utf-8");

        //gbk编码中文占用3个字节，英文占用1个字节。
        System.out.print("utf-8： ");
        for (byte b : byte1){
            System.out.print(Integer.toHexString(b) + " ");
        }

        System.out.println();

        //gbk编码中文占用2个字节，英文占用1个字节。
        System.out.print("gbk： ");
        byte[] byte2 = s.getBytes("gbk");

        for (byte b : byte2){
            System.out.print(Integer.toHexString(b) + " ");
        }

        System.out.println();

        //java是双字节编码 utf-16be
        System.out.print("utf-16be： ");
        byte[] byte3 = s.getBytes("utf-16be");
        //utf-16be中文占用2个字节 英文占用2个字节
        for (byte b : byte3){
            System.out.print(Integer.toHexString(b) + " ");
        }

        System.out.println();

        /**
         * 当你的字符串序列是某种编码时，
         * 这个时候想把字节序列编程字符串，
         * 也需要这种编码方式，
         * 否则会出现乱码
         * */

        String str1 = new String(byte3);//用项目默认编码
        System.out.println(str1);
        String str2 = new String(byte3, "utf-16be");
        System.out.println(str2);


        /**
         * 文本文件就是字节序列
         * 可以是任意编码编码的字节序列
         * 如果我们在中文机器上直接创建文本文件，那么该文件只认识ansi编码
         * 联通、联 是一种巧合，他们正好符合utf8编码的规则
         * */

    }

}
