package com.chen.api.util.thread.study.chapter4.waiitConditionNotufyError;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  chen weijie
 * @Date: 2018-05-17 00:48
 */
public class MyService {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void await() {

        try {
            lock.lock();
            System.out.println("a");
            //调用await方法使得执行任务的队列进入waiting状态。
            condition.await();
            System.out.println("b");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
