package com.chen.api.util.thread.study.chapter2.t9;

/**
 * @author chen weijie
 * @date 2018-04-16 12:57 AM
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        MyOneList list = new MyOneList();
        ThreadA threadA = new ThreadA(list);
        threadA.setName("A");
        threadA.start();

        ThreadB threadB = new ThreadB(list);
        threadB.setName("B");
        threadB.start();
        Thread.sleep(6000);
        System.out.println("list.size()====" + list.getSize());

    }

}
