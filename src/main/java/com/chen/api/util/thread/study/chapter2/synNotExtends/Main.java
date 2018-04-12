package com.chen.api.util.thread.study.chapter2.synNotExtends;

import com.chen.api.util.thread.study.chapter2.throwExceptionNoLock.ThreadB;

/**
 * 同步不可以继承
 *
 * @author chen weijie
 * @date 2018-04-13 1:07 AM
 */
public class Main {


    synchronized public void serviceMethod() {
        System.out.println("int main 下一步 sleep begin threadName=" + Thread.currentThread().getName() + ",time===" + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("int main 下一步 sleep end threadName=" + Thread.currentThread().getName() + ",time===" + System.currentTimeMillis());
    }

}
