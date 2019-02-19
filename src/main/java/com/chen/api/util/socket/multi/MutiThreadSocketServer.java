package com.chen.api.util.socket.multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 多线程socketServer
 *
 * @author :  chen weijie
 * @Date: 2019-01-03 8:46 PM
 */
public class MutiThreadSocketServer {


    public static void main(String[] args) {

        /**
         6、应用多线程实现服务器与多客户端之间的通信
         ① 服务器端创建ServerSocket，循环调用accept()等待客户端连接
         ② 客户端创建一个socket并请求和服务器端连接
         ③ 服务器端接受苦读段请求，创建socket与该客户建立专线连接
         ④ 建立连接的两个socket在一个单独的线程上对话
         ⑤ 服务器端继续等待新的连接
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        try {
            //1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
            //1024-65535的某个端口
            ServerSocket serverSocket = new ServerSocket(8080);
            //2、调用accept()方法开始监听，等待客户端的连接
            Socket socket = null;
            //记录客户端的数量
            int count = 0;
            while (true) {
                socket = serverSocket.accept();
                Task task = new Task(socket);
                executor.execute(task);
                count++;
                System.out.println("客户端连接的数量：" + count);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
