package com.zhengxin.nio;

import com.mysql.fabric.Server;
import org.bson.ByteBuf;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static jdk.nashorn.internal.objects.NativeFunction.bind;

/**
 * @author zhengxin
 * @date 2018-05-03 14:26:53
 */
public class TestBlockingNIO2 {

    String src = "/Users/zhengxin/Desktop/1.mp4";
    String des = "/Users/zhengxin/Desktop/2.mp4";

    @Test
    public void client(){


        try(SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
            FileChannel fileChannel = FileChannel.open(Paths.get(src), StandardOpenOption.READ)) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            while (fileChannel.read(byteBuffer) != -1){
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
            }

            socketChannel.shutdownOutput();

            //接受服务端的反馈
            int len = 0;
            while ((len = socketChannel.read(byteBuffer)) != -1){
                byteBuffer.flip();
                System.out.println(new String(byteBuffer.array(), 0, len));
                byteBuffer.clear();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void server() throws IOException {


        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        FileChannel outChannel = FileChannel.open(Paths.get(des), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        ssChannel.bind(new InetSocketAddress(9898));

        SocketChannel sChannel = ssChannel.accept();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (sChannel.read(buf) != -1) {
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        //发送反馈给客户端
        buf.put("服务端接收数据成功".getBytes());
        buf.flip();
        sChannel.write(buf);

        sChannel.close();
        outChannel.close();
        ssChannel.close();
    }
}
