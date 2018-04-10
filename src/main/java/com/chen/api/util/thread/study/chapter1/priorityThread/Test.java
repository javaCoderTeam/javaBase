package com.chen.api.util.thread.study.chapter1.priorityThread;

/**
 * 测试类
 *
 * @author chen weijie
 * @date 2018-04-11 1:14 AM
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("main thread priority begin=" + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main thread priority end=" + Thread.currentThread().getPriority());

        //main线程把thread1启动,此后 线程1的线程优先级为6 此后线程1把线程2启动,线程2的优先级为6
        MyThread thread1 = new MyThread();
        thread1.start();


    }

}
