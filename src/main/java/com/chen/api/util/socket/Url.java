package com.chen.api.util.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author :  chen weijie
 * @Date: 2019-01-03 9:14 PM
 */
public class Url {
    /**
     * @author :  chen weijie
     * @Date: 2019-01-02 10:12 AM
     */
    public static class URLTest {

        public static void main(String[] args) {
            try {
                //创建一个URL实例
                URL url = new URL("http://www.baidu.com");
                //通过openStream方法获取资源的字节输入流
                InputStream inputStream = url.openStream();
                //将字节输入流转换为字符输入流,如果不指定编码，中文可能会出现乱码
                InputStreamReader streamReader = new InputStreamReader(inputStream, "utf-8");
                //为字符输入流添加缓冲，提高读取效率
                BufferedReader bufferedReader = new BufferedReader(streamReader);
                //读取数据
                String data = bufferedReader.readLine();
                while (data != null) {
                    //输出数据
                    System.out.println(data);
                    data = bufferedReader.readLine();
                }
                bufferedReader.close();
                streamReader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
