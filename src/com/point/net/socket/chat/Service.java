package com.point.net.socket.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lzhijin Cotter on 2020/5/11.
 */
public class Service {
    public static void main(String[] args) throws IOException  {
        // 1 创建服务器 指定端口
        ServerSocket server = new ServerSocket(8888);
        // 2接受客户端链接
        Socket socket = server.accept();
        System.out.println("一个客户端建立链接");
        // 输入流
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        String ims = inputStream.readUTF();
        // 输出流
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        outputStream.writeUTF("服务器--》" + ims);
        outputStream.flush();
    }
}
