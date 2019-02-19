package com.chen.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author :  chen weijie
 * @Date: 2019-01-04 10:48 AM
 */
public class ServerSocketTest {


    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(10000);
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String serverInfo = "我是服务端，客户端说:";
            String outInfo;

            while ((outInfo = bufferedReader.readLine()) != null) {
                System.out.println(serverInfo + outInfo);
            }
            socket.shutdownInput();

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);
            pw.write("欢迎！");
            pw.flush();

            pw.close();
            outputStream.close();
            bufferedReader.close();
            inputStreamReader.close();
            is.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
