package com.chen.api.util.thread.study.chapter1.stopThread;

/**
 * stop暴力中止线程
 *
 * @author chen weijie
 * @date 2018-04-10 12:48 AM
 */
public class StopThread extends Thread {

    private int i = 0;

    @Override
    public void run() {

        while (true) {
            i++;
            try {
                Thread.sleep(1000);
                System.out.println("i====" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
