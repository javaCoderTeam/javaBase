package com.chen.api.util.thread.study.chapter4.getQueueLengthTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  chen weijie
 * @Date: 2018-05-20 23:31
 */
public class Service {

    public ReentrantLock lock =new ReentrantLock();


    public void serviceMethod1 (){

        try {
            lock.lock();

            System.out.println("ThreadName:"+Thread.currentThread().getName()+"进入方法！");
//            System.out.println("当前线程调用lock的次数："+lock.getHoldCount());
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }



}
