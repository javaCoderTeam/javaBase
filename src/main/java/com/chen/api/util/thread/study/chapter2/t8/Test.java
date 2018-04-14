package com.chen.api.util.thread.study.chapter2.t8;

/**
 * @author chen weijie
 * @date 2018-04-15 1:56 AM
 */
public class Test {


    public static void main(String[] args) {

        Task task = new Task();

        ThreadA threadA = new ThreadA(task);
        ThreadB threadB = new ThreadB(task);
        threadA.setName("A");
        threadB.setName("B");
        threadA.start();
        threadB.start();


    }

}
