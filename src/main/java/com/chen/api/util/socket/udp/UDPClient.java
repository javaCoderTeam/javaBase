package com.chen.api.util.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 客户端实现步骤
 * <p>
 * ① 定义发送信息
 * ② 创建DatagramPacket，包含将要发送的信息
 * ③ 创建DatagramSocket
 * ④ 发送数据
 *
 * @author :  chen weijie
 * @Date: 2019-01-03 9:25 PM
 */
public class UDPClient {

    public static void main(String[] args) {

        //客户端
        //1、定义服务器的地址、端口号、数据
        try {
            InetAddress address = InetAddress.getByName("localhost");
            int port = 10000;
            byte[] data = "用户名：admin;密码：123".getBytes();
            //2、创建数据报，包含发送的数据信息
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            // 3.创建DatagramSocket对象
            DatagramSocket socket = new DatagramSocket();
            //4、向服务器发送数据
            socket.send(packet);


            //接受服务器端响应数据
            //1、创建数据报，用于接受服务器端响应数据
            byte[] data2 = new byte[1024];
            DatagramPacket packet1 = new DatagramPacket(data2, data2.length);
            //2、接受服务器响应的数据
            socket.receive(packet1);
            String reply = new String(data2, 0, packet1.getLength());
            System.out.println("我是客户端，服务器说：" + reply);
            //4、关闭资源
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
