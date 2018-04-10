package com.chen.api.util.thread.study.chapter1.suspendAndResumeTest;

/**
 * 线程的暂停和恢复
 *
 * @author chen weijie
 * @date 2018-04-10 11:59 PM
 */
public class MyThread extends Thread {

    private long n = 0;

    public long getN() {
        return n;
    }

    public void setN(long n) {
        this.n = n;
    }

    @Override
    public void run() {
        while (true) {
            n++;
//            System.out.println(n);
        }

    }

}
