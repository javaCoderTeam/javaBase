package com.chen.api.util.thread.study.chapter1.statusStopThread;

/**
 * 测试类
 *
 * @author chen weijie
 * @date 2018-04-10 12:06 AM
 */
public class StatusStopThreadTest {

    public static void main(String[] args) {

        StatusStopThread thread = new StatusStopThread();
        thread.start();
        try {
            System.out.println("sleep............");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
        System.out.println("end--------");
    }
}
