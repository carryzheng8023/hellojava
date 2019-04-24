package com.zhengxin.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zhengxin
 * @date 2018-05-30 19:28:30
 */
public class TestInetAddress {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress);
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress());

        InetAddress inetAddress1 = InetAddress.getLocalHost();
        System.out.println(inetAddress1);
        System.out.println(inetAddress1.getHostName());
        System.out.println(inetAddress1.getHostAddress());

    }

}
