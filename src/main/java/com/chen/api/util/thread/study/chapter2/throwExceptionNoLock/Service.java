package com.chen.api.util.thread.study.chapter2.throwExceptionNoLock;

/**
 * 当一个线程执行的代码出现异常时,其所持有的锁会自动释放.
 *
 * @author chen weijie
 * @date 2018-04-13 12:54 AM
 */
public class Service {

    synchronized public void testMethod() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("thread name =" + Thread.currentThread().getName() + "run begin time==" + System.currentTimeMillis());
            int i = 1;
            while (i < 10000) {
                System.out.println(111111111);
                i++;
            }
            throw new RuntimeException("Exception");

        } else {
            System.out.println("Thread B run time =" + System.currentTimeMillis());
        }


    }


}
