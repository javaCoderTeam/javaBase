package com.chen.api.util.socket.simple;

import java.io.*;
import java.net.Socket;

/**
 *
 1、TCP协议是面向连接的、可靠的、有序的、以字节流的方式发送数据，通过三次握手方式建立连接，形成传输数据的通道，在连接中进行大量数据的传输，效率会稍低
 2、Java中基于TCP协议实现网络通信的类
 客户端的Socket类
 服务器端的ServerSocket类
 *
 * @author :  chen weijie
 * @Date: 2019-01-03 8:19 PM
 */
public class SocketClient {


    public static void main(String[] args) {

        try {
            //客户端
            //1、创建客户端Socket，指定服务器地址和端口
            Socket socket = new Socket("localhost", 10086);
            //2、获取输出流，向服务器端发送信息
            //字节输出流
            OutputStream os = socket.getOutputStream();
            //将输出流包装成打印流
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名：admin；密码：123");
            pw.flush();
            socket.shutdownOutput();
            //3、获取输入流，并读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info;
            while ((info = br.readLine()) !=null){
                System.out.println("我是客户端，服务器说：" + info);
            }

            //4、关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
