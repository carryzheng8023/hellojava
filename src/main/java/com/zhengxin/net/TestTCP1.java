package com.zhengxin.net;

import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhengxin
 * @date 2018-05-30 19:49:33
 */
public class TestTCP1 {

    @Test
    public void client() throws Exception{

        Socket socket = new Socket(InetAddress.getLocalHost(), 7788);

        OutputStream os = socket.getOutputStream();

        os.write("我是客户端".getBytes());

        os.close();

        socket.close();

    }

    @Test
    public void server() throws Exception{

        ServerSocket serverSocket = new ServerSocket(7788);

        Socket clientSocket = serverSocket.accept();

        InputStream is = clientSocket.getInputStream();

        byte[] b = new byte[20];

        int len;

        while ((len = is.read(b)) != -1){
            String string = new String(b, 0, len);
            System.out.print(string);
        }

        is.close();
        clientSocket.close();
        serverSocket.close();
    }

}
