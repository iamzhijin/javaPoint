package com.point.net.socket.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lzhijin Cotter on 2020/5/14.
 */
public class Receiver {

    private DataInputStream inputStream;

    private boolean isRunning;

    public Receiver(){}

    public Receiver(Socket clien){
        try {
            inputStream = new DataInputStream(clien.getInputStream()); //  获取输入消息
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
