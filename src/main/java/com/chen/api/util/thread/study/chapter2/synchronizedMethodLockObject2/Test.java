package com.chen.api.util.thread.study.chapter2.synchronizedMethodLockObject2;

import com.chen.api.util.thread.study.chapter2.synchronizedMethodLockObject.MyObject;

/**
 * A线程持有了object对象的锁,但是B线程可以异步调用非synchronize修饰的方法
 *
 * 结论:A线程先持有object对象的lock锁,B线程可以异步的调用object对象中的非synchronize类型的方法;
 *     A线程先持有object对象的lock锁,B线程如果在这是调用object对象中synchronize类型的方法 需要等待,也就是同步
 *
 *
 * @author chen weijie
 * @date 2018-04-12 2:26 AM
 */
public class Test {

    public static void main(String[] args) {

        MyObjectOT myObject = new MyObjectOT();
        ThreadA threadA = new ThreadA(myObject);
        ThreadB threadB = new ThreadB(myObject);
        threadA.setName("a");
        threadB.setName("b'");
        threadA.start();
        threadB.start();
    }
}
