package com.chen.api.util.thread.study.chapter3.pipeInputOutput;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author :  chen weijie
 * @Date: 2018-05-15 00:13
 */
public class Run {


    public static void main(String[] args) {

        ReadData readData = new ReadData();
        PipedInputStream inputStream = new PipedInputStream();
        WriteData writeData = new WriteData();
        PipedOutputStream outputStream = new PipedOutputStream();
        try {
            outputStream.connect(inputStream);

            ThreadRead threadRead = new ThreadRead(readData, inputStream);
            threadRead.start();
            Thread.sleep(2000);

            ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
            threadWrite.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
