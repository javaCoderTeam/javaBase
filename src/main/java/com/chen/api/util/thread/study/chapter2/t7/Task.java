package com.chen.api.util.thread.study.chapter2.t7;

/**
 * 方法中一半同步一半异步执行..
 * <p>
 * 同步代码,执行排队执行,非同步代码交叉执行
 *
 * @author chen weijie
 * @date 2018-04-15 1:21 AM
 */
public class Task {

    public void doLongTimeTask() {

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("noSynchronized threadName:" + Thread.currentThread().getName() + ",i=" + i);
        }

        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("synchronized threadName:" + Thread.currentThread().getName() + ",i=" + i);
            }
        }
    }

}
