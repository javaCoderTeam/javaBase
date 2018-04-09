package com.chen.api.util.thread.study.chapter1.sleepStopException;

/**
 * 测试类
 *
 * @author chen weijie
 * @date 2018-04-10 12:41 AM
 */
public class SleepInterruptThreadTest {


    public static void main(String[] args) {

        SleepInterruptThread thread = new SleepInterruptThread();
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
