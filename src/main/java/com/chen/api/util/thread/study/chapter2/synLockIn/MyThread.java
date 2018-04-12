package com.chen.api.util.thread.study.chapter2.synLockIn;

/**
 * @author chen weijie
 * @date 2018-04-13 12:45 AM
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }
}
