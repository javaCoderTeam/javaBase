package com.chen.api.util.thread.study.chapter4.lockMethodTest2;


/**
 * 查询是否当前线程在等待此锁 和 有线程在等待此锁
 *
 * @author :  chen weijie
 * @Date: 2018-05-21 00:15
 */
public class Run {

    public static void main(String[] args) {

        final Service service = new Service();

        try {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    service.waitMethod();
                }
            };

            Thread threadA = new Thread(runnable);
            threadA.start();
            Thread.sleep(10);
            Thread threadB = new Thread(runnable);
            threadB.start();

            System.out.println(service.lock.hasQueuedThread(threadA));
            System.out.println(service.lock.hasQueuedThread(threadB));
            System.out.println(service.lock.hasQueuedThreads());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
