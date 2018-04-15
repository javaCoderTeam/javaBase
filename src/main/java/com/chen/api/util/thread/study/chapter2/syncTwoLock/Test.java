package com.chen.api.util.thread.study.chapter2.syncTwoLock;

/**
 * @author chen weijie
 * @date 2018-04-16 3:12 AM
 */
public class Test {

    //虽然 a和b线程使用了两个锁,但是这两个锁其实时静态类锁,所以锁的是同一个类.导致两个对象实例锁的是同一个类.
    public static void main(String[] args) {

        Service service1 = new Service();
        Service service2 = new Service();

        ThreadA threadA = new ThreadA(service1);
        ThreadB threadB = new ThreadB(service2);

        threadA.setName("a");
        threadB.setName("b");
        threadA.start();
        threadB.start();


    }
}
