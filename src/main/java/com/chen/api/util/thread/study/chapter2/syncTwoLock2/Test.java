package com.chen.api.util.thread.study.chapter2.syncTwoLock2;

/**
 * @author chen weijie
 * @date 2018-04-16 3:12 AM
 */
public class Test {

    //由于AB使用的synchronized锁修饰的是静态方法(类锁),而C修饰的是方法(对象锁) 所以C线程时异步的 ab同步的.
    public static void main(String[] args) {

        Service service = new Service();

        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        ThreadC threadC = new ThreadC(service);

        threadA.setName("a");
        threadB.setName("b");
        threadC.setName("c");
        threadA.start();
        threadB.start();
        threadC.start();


    }
}
