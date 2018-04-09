package com.chen.api.util.thread.study.chapter1.stopThread;

/**
 * stop中止线程
 *
 * @author chen weijie
 * @date 2018-04-10 12:50 AM
 */
public class StopThreadTest {

    public static void main(String[] args) {

        StopThread thread =new StopThread();

        thread.start();
        try {
            thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();

    }

}
