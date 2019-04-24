package com.zhengxin.net;

import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author zhengxin
 * @date 2018-05-30 20:23:02
 */
public class TestUDP {


    @Test
    public void send() throws Exception{

        DatagramSocket ds = new DatagramSocket();

        byte[] b = "这是数据".getBytes();

        DatagramPacket pack = new DatagramPacket(b, 0, b.length, InetAddress.getLocalHost(), 7788);

        ds.send(pack);

        ds.close();

    }

    @Test
    public void receive() throws Exception{

        DatagramSocket ds = new DatagramSocket(7788);

        byte[] b = new byte[1024];

        DatagramPacket packet = new DatagramPacket(b, 0, b.length);

        ds.receive(packet);

        String str = new String(packet.getData(), 0 ,packet.getLength());

        System.out.println(str);

        ds.close();

    }

}
