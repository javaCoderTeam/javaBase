package com.chen.api.util.socket.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author :  chen weijie
 * @Date: 2020-05-29 00:01
 */
public class IOClient {


    public static void main(String[] args) {
        // TODO 创建多个线程，模拟多个客户端连接服务端

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Socket socket = new Socket("localhost",3333);
                    while (true){
                        socket.getOutputStream().write((new Date() + " hello world").getBytes());
                        Thread.sleep(2000);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

}
