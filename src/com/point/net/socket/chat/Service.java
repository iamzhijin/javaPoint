package com.point.net.socket.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzhijin Cotter on 2020/5/11.
 */
public class Service {
    private List<Channel> channelList = new ArrayList<>();
    public static void main(String[] args) throws IOException  {
        new Service().start();
    }

    public void start()throws IOException{
        // 1 创建服务器 指定端口
        ServerSocket server = new ServerSocket(8888);
        // 2接受客户端链接
        while (true){
            Socket client = server.accept();
            Channel channel = new Channel(client);
            channelList.add(channel);
            new Thread(channel).start();
        }

    }

    class Channel implements Runnable{
        private DataInputStream inputStream;
        private DataOutputStream outputStream;
        private boolean isRunning = true;

        public Channel(Socket client){
            try {
                inputStream = new DataInputStream(client.getInputStream());
                outputStream = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                isRunning = false;
                IoCloseUtil.closedAll(inputStream, outputStream);
            }

        }

        public String receive(){
            String msg = "";
            try {
                msg = inputStream.readUTF();
            } catch (IOException e) {
                isRunning = false;
                IoCloseUtil.closedAll(inputStream);
                channelList.remove(this);
            }
            return msg;
        }

        public void send(String msg){
            try {
                outputStream.writeUTF(msg);
                outputStream.flush();
            } catch (IOException e) {
                isRunning = false;
                IoCloseUtil.closedAll(outputStream);
                channelList.remove(this);
            }
        }

        public void sendOther(){
            String msg = receive();
            System.out.println("服务器接到消息" + msg);
            if (msg != null && !msg.equals("")){
                for (Channel channel: channelList){
                    if (channel == this){
                        continue;
                    }
                    System.out.println(channel);
                    channel.send(msg);
                    System.out.println("服务器发送数据:" + msg);
                }
            }
        }

        @Override
        public void run() {
            while (isRunning){
                sendOther();
            }

        }
    }
}
