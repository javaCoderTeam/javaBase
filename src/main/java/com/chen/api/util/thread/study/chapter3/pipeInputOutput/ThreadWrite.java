package com.chen.api.util.thread.study.chapter3.pipeInputOutput;

import java.io.PipedOutputStream;

/**
 * @author :  chen weijie
 * @Date: 2018-05-15 00:07
 */
public class ThreadWrite extends Thread {


    private WriteData writeData;

    private PipedOutputStream outputStream;

    public ThreadWrite(WriteData writeData, PipedOutputStream outputStream) {
        this.writeData = writeData;
        this.outputStream = outputStream;
    }


    @Override
    public void run() {
        writeData.writeMethod(outputStream);
    }


}
