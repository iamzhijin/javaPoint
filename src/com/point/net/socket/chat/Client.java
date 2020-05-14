package com.point.net.socket.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lzhijin Cotter on 2020/5/11.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 1 创建客户端 并指定服务端及端口
        Socket client = new Socket("localhost", 8888);
        // 多线程
        new Thread(new Send(client)).start(); // 客户端1
        new Thread(new Send(client)).start(); // 客户端2
    }
}
