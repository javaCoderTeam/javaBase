package com.chen.api.util.thread.study.chapter1.sleepStopException;

/**
 * 沉睡中中止线程
 *
 * @author chen weijie
 * @date 2018-04-10 12:39 AM
 */
public class SleepInterruptThread extends Thread {


    @Override
    public void run(){
        System.out.println("beginning............");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被中止.......interrupt");
            e.printStackTrace();
        }
        System.out.println("end........");

    }
}
