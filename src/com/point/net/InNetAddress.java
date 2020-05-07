package com.point.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lzhijin Cotter on 2020/5/7.
 */
public class InNetAddress {

    public static void main(String[] args) {

        {
            try {
                // 根据域名获取inetAddress对象
                InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
                System.out.println(inetAddress);

                // 获取所有的inetAddress对象
                InetAddress[] inetAddressArray = InetAddress.getAllByName("www.baidu.com");
                System.out.println(Arrays.toString(inetAddressArray));

                // 获取本地inetAddress对象
                InetAddress inetAddressLocal = InetAddress.getLocalHost();
                System.out.println(inetAddressLocal);

                // 根据IP获取域名
                String inetAddressHost = inetAddress.getHostName();
                System.out.println(inetAddressHost);

                // 测试是否可以到达指定地址
                boolean inetAddressR = inetAddress.isReachable(1000);
                System.out.println(inetAddressR);

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
