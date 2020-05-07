package com.point.net;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * Created by lzhijin Cotter on 2020/5/7.
 */
public class InetSocket {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8081);

        InetAddress inetAddress = inetSocketAddress.getAddress();
        System.out.println(inetAddress);

        Integer port = inetSocketAddress.getPort();
        System.out.println(port);

        String hostName = inetSocketAddress.getHostName();
        System.out.println(hostName);
    }
}
