package com.chen.api.util.thread.study.chapter1.statusStopThread;

/**
 * 测试类
 *
 * @author chen weijie
 * @date 2018-04-10 12:31 AM
 */
public class ExceptionStopThreadTest {

    public static void main(String[] args) {
        ExceptionStopThread thread = new ExceptionStopThread();
        thread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
