package com.point.net.socket.chat;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by lzhijin Cotter on 2020/5/12.
 * IO 流关闭工具
 */
public class IoCloseUtil {

    public static void closedAll(Closeable... closeables){
        for (Closeable closeable: closeables){
            if (closeable != null){
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
