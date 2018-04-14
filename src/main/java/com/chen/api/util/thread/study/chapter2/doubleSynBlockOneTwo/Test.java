package com.chen.api.util.thread.study.chapter2.doubleSynBlockOneTwo;

/**
 * @author chen weijie
 * @date 2018-04-15 1:42 AM
 */
public class Test {

    public static void main(String[] args) {

        ObjectService service = new ObjectService();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        threadA.setName("A");
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }

}
