package com.chen.api.util.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 UDP协议（用户数据报协议）是无连接的、不可靠的、无序的,速度快
 进行数据传输时，首先将要传输的数据定义成数据报（Datagram），大小限制在64k，在数据报中指明数据索要达到的Socket（主机地址和端口号），然后再将数据报发送出去
 DatagramPacket类:表示数据报包
 DatagramSocket类：进行端到端通信的类

 * @author :  chen weijie
 * @Date: 2019-01-03 9:14 PM
 */
public class UDPServer {


    public static void main(String[] args) {


        //服务器端，实现基于UDP的用户登录
        try {
            //1、创建服务器端DatagramSocket，指定端口
            DatagramSocket socket = new DatagramSocket(10000);
            //2、创建数据报，用于接受客户端发送的数据
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            //3、接受客户端发送的数据
            socket.receive(packet);
            //4、读取数据
            String info = new String(data, 0, data.length);
            System.out.println("我是服务器，客户端告诉我" + info);


            //向客户端响应数据
            InetAddress address = packet.getAddress();
            //1、定义客户端的地址、端口号、数据
            int port = packet.getPort();
            byte[] data2 = "欢迎您！".getBytes();
            //2、创建数据报，包含响应的数据信息
            DatagramPacket packet1 = new DatagramPacket(data2, data2.length, address, port);
            //3、响应客户端
            socket.send(packet1);
            //4、关闭资源
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
