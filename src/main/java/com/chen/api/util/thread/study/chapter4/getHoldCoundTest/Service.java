package com.chen.api.util.thread.study.chapter4.getHoldCoundTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  chen weijie
 * @Date: 2018-05-20 23:24
 */
public class Service {

    private ReentrantLock lock = new ReentrantLock();

    public void serviceMethod1() {
        try {
            lock.lock();
            System.out.println("serviceMethod1 getHoldCount=" + lock.getHoldCount());
            serviceMethod2();
        } finally {
            lock.unlock();
        }
    }

    public void serviceMethod2() {

        try {
            lock.lock();
            System.out.println("serviceMethod2 getHoldCount=" + lock.getHoldCount());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        Service service = new Service();

        service.serviceMethod1();


    }


}
