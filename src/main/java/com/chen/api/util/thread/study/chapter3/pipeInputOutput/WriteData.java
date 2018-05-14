package com.chen.api.util.thread.study.chapter3.pipeInputOutput;

import java.io.PipedOutputStream;

/**
 * 写操作
 *
 * @author :  chen weijie
 * @Date: 2018-05-14 23:57
 */
public class WriteData {

    public void writeMethod(PipedOutputStream outputStream) {

        System.out.println("write:");
        try {
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                outputStream.write(outData.getBytes());
                System.out.println(outData);
            }
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
