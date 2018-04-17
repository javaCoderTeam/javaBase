package com.chen.api.util.thread.study.chapter2.twoStop;

/**
 * @author chen weijie
 * @date 2018-04-18 12:00 AM
 */
public class Test {

    public static void main(String[] args) {

        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        threadA.setName("a");
        threadB.setName("b");
        threadA.start();
        threadB.start();

    }

}
