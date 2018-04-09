package com.chen.api.util.thread.study.chapter1.statusStopThread;

/**
 * 通过判断线程是否是停止状态,如果是停止状态,则停止执行后续代码
 *
 * @author chen weijie
 * @date 2018-04-10 12:03 AM
 */
public class StatusStopThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 5000000; i++) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            System.out.println("i=========" + i);

        }
        System.out.println("---------");

    }
}
