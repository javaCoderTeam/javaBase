package com.chen.api.util.thread.study.chapter3.waitReleaseLock;

/**
 * 当方法wait被执行后,锁被自动释放,执行notify方法后,锁却不自动释放
 *
 * @author chen weijie
 * @date 2018-05-07 11:54 PM
 */
public class Service {

    public void testMethod(Object lock) {

        try {
            synchronized (lock) {
                System.out.println("begin wait");
//                lock.wait();
                Thread.sleep(1000);
                System.out.println("end wait");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
