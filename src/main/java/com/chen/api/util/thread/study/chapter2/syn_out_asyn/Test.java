package com.chen.api.util.thread.study.chapter2.syn_out_asyn;

/**
 * 结果是成对出现的,所以方法是同步执行的
 * <p>
 * 同步快中的代码是同步打印的,当前线程执行是成对出现的.但线程A和线程B的执行却是异步的,这样可能出现脏读的环境.
 *
 * @author chen weijie
 * @date 2018-04-16 12:35 AM
 */
public class Test {

    public static void main(String[] args) {

        MyList list = new MyList();
        ThreadA threadA = new ThreadA(list);
        ThreadB threadB = new ThreadB(list);
        threadA.setName("A");
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }
}
