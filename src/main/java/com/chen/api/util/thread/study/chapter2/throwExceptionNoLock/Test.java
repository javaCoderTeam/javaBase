package com.chen.api.util.thread.study.chapter2.throwExceptionNoLock;

/**
 * @author chen weijie
 * @date 2018-04-13 1:00 AM
 */
public class Test {

    public static void main(String[] args) {

        Service service = new Service();

        ThreadA threadA = new ThreadA(service);
        threadA.setName("a");
        threadA.start();

        ThreadB threadB = new ThreadB(service);
        threadB.start();

    }

}
