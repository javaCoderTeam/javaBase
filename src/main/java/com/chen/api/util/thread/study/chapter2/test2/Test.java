package com.chen.api.util.thread.study.chapter2.test2;

/**
 * 当其它线程执行x对象中的synchronized方法时呈现同步效果;
 *
 * @author chen weijie
 * @date 2018-04-16 1:43 AM
 */
public class Test {

    public static void main(String[] args) {

        Service service = new Service();
        MyObject myObject = new MyObject();

        ThreadA threadA = new ThreadA(myObject, service);
        ThreadB threadB = new ThreadB(myObject, service);
        threadA.setName("A");
        threadB.setName("B");
        threadA.start();
        threadB.start();


    }

}

