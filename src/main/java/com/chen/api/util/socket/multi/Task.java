package com.chen.api.util.socket.multi;

import java.io.*;
import java.net.Socket;

/**
 * @author :  chen weijie
 * @Date: 2019-01-03 8:50 PM
 */
public class Task implements Runnable {


    Socket socket;

    public Task(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            //3、获取输入流，并读取客户端信息
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String info;
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器，客户端说：" + info);
            }
            //关闭输入流
            socket.shutdownInput();
            //4、获取输出流，响应客户端的请求
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("欢迎您！");
            pw.flush();

            //5、关闭资源
            pw.close();
            os.close();
            br.close();
            isr.close();
            is.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
