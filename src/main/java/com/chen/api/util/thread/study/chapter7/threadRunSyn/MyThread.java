package com.chen.api.util.thread.study.chapter7.threadRunSyn;

/**
 * @author :  chen weijie
 * @Date: 2018-05-30 01:00
 */
public class MyThread extends Thread {

    private Object lock;

    private String showChar;

    private int showNumPostitions;

    private int printCount;

    volatile private static int addNumber = 1;

    public MyThread(Object lock, String showChar, int showNumPostitions) {
        this.lock = lock;
        this.showChar = showChar;
        this.showNumPostitions = showNumPostitions;
    }


    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (true) {
                    if (addNumber % 3 == showNumPostitions) {
                        System.out.println("threadName:" + Thread.currentThread().getName() + " runCount:" + addNumber + " " + showChar);
                        lock.notifyAll();
                        addNumber++;
                        printCount++;
                        if (printCount == 3) {
                            break;
                        }
                    } else {
                        lock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
