package com.chen.api.util.io.inputstream;

import org.junit.Test;

import java.io.*;

/**
 * Created by Chen Weijie on 2017/8/6.
 */
public class FileInputStreamTest {


    @Test
    public void testInputStream() {

        try {
            //根据文件名字创建字节输入流
            int n;
            InputStream inputStream = new FileInputStream("E:\\ideaWorkSpace\\java-chenwj\\src\\main\\resources\\log4j2.xml");

            byte[] bytes = new byte[100];
            try {
                while ((n = inputStream.read(bytes)) != -1) {
                    String s = new String(bytes, 0, n);
                    System.out.println(s);

                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testInputStream2(){

        int n;
        byte [] b =new byte[1000];
        try {
            File file =new File("E:\\data\\logs\\vertxStudy.log");
            //根据file创建字节输入流
            FileInputStream fileInputStream =new FileInputStream(file);
            while ((n = fileInputStream.read(b)) != -1){
                String string =new String(b,0,n);
                System.out.println(string);
            }
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testOutPutStream(){

        byte [] bytes ="你好,最近忙吗？".getBytes();

        try {
            FileOutputStream fileOutputStream =new FileOutputStream("E:\\data\\logs\\test.log");
            fileOutputStream.write(bytes);
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
