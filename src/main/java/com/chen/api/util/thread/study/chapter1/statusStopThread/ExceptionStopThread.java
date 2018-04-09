package com.chen.api.util.thread.study.chapter1.statusStopThread;

/**
 * 通过抛出异常中断线程
 *
 * @author chen weijie
 * @date 2018-04-10 12:14 AM
 */
public class ExceptionStopThread extends Thread {

    @Override
    public void run() {

        super.run();

        for (int i = 0; i < 5000000; i++) {
            System.out.println("i======" + i);
            if (this.isInterrupted()) {
                System.out.println("中断....");
                throw new RuntimeException("exception interrupt thread");
            }
        }
    }
}
