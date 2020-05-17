package com.point.net.socket.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by lzhijin Cotter on 2020/5/14.
 */
public class Receiver implements Runnable{

    private DataInputStream inputStream;

    private boolean isRunning = true;

    public Receiver(){}

    public Receiver(Socket client){
        try {
            inputStream = new DataInputStream(client.getInputStream()); //  获取输入消息
        } catch (IOException e) {
            isRunning = false;
            IoCloseUtil.closedAll(inputStream);
        }
    }

    /**
     * 读取管道中的数据
     */
    public String receive(){
        try {
            return inputStream.readUTF();
        } catch (IOException e) {
            isRunning = false;
            IoCloseUtil.closedAll(inputStream);
        }
        return null;
    }

    @Override
    public void run() {
        while (isRunning){
            System.out.println("接受者：" + receive());
        }
    }
}
