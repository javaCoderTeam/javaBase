package com.chen.api.util.thread.study.chapter1.daemonThread;

/**
 * 守护线程
 *
 * @author chen weijie
 * @date 2018-04-11 1:59 AM
 */
public class MyThread extends Thread {

    private int i = 0;

    @Override
    public void run() {
        while (true) {
            try {
                i++;
                System.out.println("i=" + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
