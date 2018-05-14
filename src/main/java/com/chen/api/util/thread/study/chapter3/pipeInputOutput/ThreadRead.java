package com.chen.api.util.thread.study.chapter3.pipeInputOutput;

import java.io.PipedInputStream;

/**
 * @author :  chen weijie
 * @Date: 2018-05-15 00:12
 */
public class ThreadRead extends Thread {


    private ReadData readdata;

    private PipedInputStream pipedInputStream;

    public ThreadRead(ReadData readdata, PipedInputStream pipedInputStream) {
        this.readdata = readdata;
        this.pipedInputStream = pipedInputStream;
    }

    public void run() {
        readdata.readMethod(pipedInputStream);
    }


}
