package com.chen.api.util.thread.study.chapter2.synBlockMoreObjectOneLock;

/**
 * synchronized(class)代码块和synchronized static方法的作用一样.
 *
 * @author chen weijie
 * @date 2018-04-16 3:29 AM
 */
public class Test {

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
