package com.chen.api.util.thread.study.chapter2.synNotExtends;

import com.chen.api.util.thread.study.chapter2.throwExceptionNoLock.ThreadA;
import com.chen.api.util.thread.study.chapter2.throwExceptionNoLock.ThreadB;

/**
 * @author chen weijie
 * @date 2018-04-13 1:14 AM
 */
public class Test {

    public static void main(String[] args) {
        Sub sub = new Sub();
        MyThreadA threadA = new MyThreadA(sub);
        threadA.setName("a");
        threadA.start();


        MyThreadB threadB = new MyThreadB(sub);
        threadB.setName("b");
        threadB.start();
    }


}
