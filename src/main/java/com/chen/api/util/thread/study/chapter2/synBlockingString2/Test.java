package com.chen.api.util.thread.study.chapter2.synBlockingString2;

/**
 * @author chen weijie
 * @date 2018-04-15 2:33 AM
 */
public class Test {

    public static void main(String[] args) {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        threadA.setName("aaaaaaaaaaaaaaaaaaaa");
        threadB.setName("bbbbbbbbbbbbbbbbbbbb");
        threadA.start();
        threadB.start();
    }

}
