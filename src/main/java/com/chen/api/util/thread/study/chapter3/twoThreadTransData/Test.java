package com.chen.api.util.thread.study.chapter3.twoThreadTransData;

/**
 * 虽然两个线程间实现了通信,但是b线程一直在while循环检测一个条件,此时会浪费cpu资源.
 *
 * @author chen weijie
 * @date 2018-04-23 12:19 AM
 */
public class Test {

    public static void main(String[] args) {

        MyList list = new MyList();

        ThreadA threadA = new ThreadA(list);
        threadA.setName("a");
        threadA.start();

        ThreadB threadB = new ThreadB(list);
        threadB.setName("b");
        threadB.start();

    }


}
