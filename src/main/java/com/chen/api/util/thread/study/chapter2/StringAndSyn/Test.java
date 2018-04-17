package com.chen.api.util.thread.study.chapter2.StringAndSyn;

/**
 * 两个线程都持有'aa'字符串对象的锁,所以造成B线程不能执行,这就是String常量池带来的问题.
 * 因此在大多数情况下synchronized代码块都不适用String作为锁对象,而要改用其它 比如new Object()
 *
 * @author chen weijie
 * @date 2018-04-17 11:47 PM
 */
public class Test {

    public static void main(String[] args) {

        ThreadA threadA = new ThreadA("aa");
        ThreadB threadB = new ThreadB("aa");

        threadA.setName("a");
        threadB.setName("b");

        threadA.start();
        threadB.start();
    }

}
