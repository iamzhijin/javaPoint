package com.point.net.socket.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by lzhijin Cotter on 2020/5/12.
 * 发送消息线程
 */
public class Send implements Runnable{

    // 控制台输入流
    private BufferedReader console;
    // 管道输出流
    private DataOutputStream outputStream;
    // 控制线程状态
    private boolean isRunning = true;

    // 初始化构造方法
    public Send(){
        console = new BufferedReader(new InputStreamReader(System.in));
    }
    public Send(Socket socket){
        this();
        try {
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            isRunning = false;
            IoCloseUtil.closedAll(console, outputStream);
        }
    }

    /**
     * 从控制台读取数据
     */
    private String getMsg(){
        try {
            return console.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 发送数据
     */
    public void send(){
        String msg = getMsg();
        if (msg != null && !msg.equals("")) {
            try {
                outputStream.writeUTF(msg);
                outputStream.flush();
            } catch (IOException e) {
                isRunning = false;
                IoCloseUtil.closedAll(console, outputStream);
            }
        }
    }

    @Override
    public void run() {
        while (isRunning){
            send();
        }
    }
}
