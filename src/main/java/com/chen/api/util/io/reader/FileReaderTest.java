package com.chen.api.util.io.reader;

import org.junit.Test;

import java.io.*;

/**
 * Created by Chen Weijie on 2017/8/6.
 */
public class FileReaderTest {


    @Test
    public void testFileReader() {
        char[] chars = new char[10000];
        int n;
        File file2 = new File("E:\\data\\logs\\test.log");
        try {
            FileReader fileReader = new FileReader(file2);

            while ((n = fileReader.read(chars)) != -1) {
                String string = new String(chars, 0, n);
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testFileWriter(){

        try {
            char [] chars ="4点12分发起总攻！".toCharArray();
            File file =new File("E:\\data\\logs\\test.log");
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write(chars);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
