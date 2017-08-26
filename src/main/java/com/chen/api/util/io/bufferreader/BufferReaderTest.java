package com.chen.api.util.io.bufferreader;

import org.junit.Test;

import java.io.*;

/**
 * Created by Chen Weijie on 2017/8/7.
 */
public class BufferReaderTest {


    @Test
    public void testBufferReader() {

        File file = new File("E:\\data\\logs\\vertxStudy.log");
        String string;

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
            }

            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }


    @Test
    public void testBufferWriter() {

        File file = new File("E:\\data\\logs\\test2.log");
        String[] strings = {"mongodb", "redis", "mysql", "oracle", "memcache"};

        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String str : strings) {
                fileWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }



}
