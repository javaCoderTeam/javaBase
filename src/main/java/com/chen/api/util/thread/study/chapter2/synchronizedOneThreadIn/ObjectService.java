package com.chen.api.util.thread.study.chapter2.synchronizedOneThreadIn;

/**
 * synchronized同步代码块的使用
 *
 * @author chen weijie
 * @date 2018-04-14 9:54 PM
 */
public class ObjectService {

    public void serviceMethod() {

        synchronized (this) {
            try {
                System.out.println("beginTime:" + System.currentTimeMillis() + ",thread:" + Thread.currentThread().getName());
                Thread.sleep(10000);
                System.out.println("endTime:" + System.currentTimeMillis() + ",thread:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
