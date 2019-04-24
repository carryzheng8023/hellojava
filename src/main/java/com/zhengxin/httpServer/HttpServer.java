package com.zhengxin.httpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhengxin
 * @date 2018-02-08 22:36:26
 */
public class HttpServer {


    public static void main(String[] a) throws Exception {

        //启动服务，监听9090端口
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("服务器启动，监听" + 9090 + "端口" );

        while (!Thread.interrupted()){

            //不停的接收客户端请求
            Socket client = serverSocket.accept();

            //获取输入流
            InputStream is = client.getInputStream();
            OutputStream os = client.getOutputStream();

            //读取请求内容
            int len;
            byte[] buf = new byte[1024];

            while ((len=is.read(buf)) != -1){
                System.out.println(new String(buf, 0, len));
            }
        }
    }

}
