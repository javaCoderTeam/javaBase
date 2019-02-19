package com.chen.test;

import java.io.*;
import java.net.Socket;

/**
 * @author :  chen weijie
 * @Date: 2019-01-04 10:48 AM
 */
public class SocketClientTest {

    public static void main(String[] args) {


        try {
            Socket socket = new Socket("127.0.0.1", 10000);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);
            pw.write("用户名：admin,密码：123");
            pw.flush();
            socket.shutdownOutput();

            InputStream ins = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(ins);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String clientInfo = "我是客户端，我想请求登录。客户端回复：";
            String info;
            while ((info = reader.readLine()) != null) {
                System.out.println(clientInfo + info);
            }

            reader.close();
            inputStreamReader.close();
            ins.close();
            pw.close();
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
