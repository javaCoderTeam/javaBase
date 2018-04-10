package com.chen.api.util.thread.study.chapter1.priorityThread3;

/**
 * @author chen weijie
 * @date 2018-04-11 1:40 AM
 */
public class ThreadB extends Thread {

    private int count = 1;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        while (true) {
            count++;
        }

    }
}
