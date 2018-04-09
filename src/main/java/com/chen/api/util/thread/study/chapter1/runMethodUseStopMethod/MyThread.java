package com.chen.api.util.thread.study.chapter1.runMethodUseStopMethod;

/**
 * stop抛出ThreadDeath异常
 *
 * @author chen weijie
 * @date 2018-04-10 1:02 AM
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            this.stop();
        } catch (Exception e) {
            System.out.println("catch捕捉异常..");
            e.printStackTrace();
        }
    }
}
