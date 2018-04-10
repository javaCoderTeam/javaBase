package com.chen.api.util.thread.study.chapter1.priorityThread;

/**
 * 线程优先级   线程优先级的继承性: 比如A线程启动B线程,则B线程的优先级与A是一样的.
 *
 * @author chen weijie
 * @date 2018-04-11 1:08 AM
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("my thread1 priority is " + this.getPriority());
        MyThread2 thread2 = new MyThread2();
        thread2.start();
    }
}
