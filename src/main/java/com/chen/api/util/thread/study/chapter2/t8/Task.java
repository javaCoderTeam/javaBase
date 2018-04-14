package com.chen.api.util.thread.study.chapter2.t8;

/**
 * 验证 同步代码块也是锁定当前对象的 ,otherMethod方法前可以添加synchronized关键字
 *
 * @author chen weijie
 * @date 2018-04-15 1:48 AM
 */
public class Task {

    public void otherMethod() {
        System.out.println("--------------------------run-otherMethod......");
    }

    public void doLongTimeTask() {
        synchronized (this) {
            for (int i = 0; i < 10000; i++) {
                System.out.println("syn threadName:" + Thread.currentThread().getName() + ",i====" + i);
            }

        }
    }


}
