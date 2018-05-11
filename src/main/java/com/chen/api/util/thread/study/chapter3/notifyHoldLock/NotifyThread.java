package com.chen.api.util.thread.study.chapter3.notifyHoldLock;

/**
 * @author chen weijie
 * @date 2018-05-08 12:16 AM
 */
public class NotifyThread extends Thread {


    private Object lock;

    public NotifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.synNotifyMethod(lock);
    }

}
