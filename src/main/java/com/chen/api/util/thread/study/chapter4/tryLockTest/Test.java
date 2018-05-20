package com.chen.api.util.thread.study.chapter4.tryLockTest;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 00:48
 */
public class Test {

    public static void main(String[] args) {

        final MyService service = new MyService();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
            }
        };


        Thread threadA = new Thread(runnable);
        threadA.setName("a");
        threadA.start();

        Thread threadB = new Thread(runnable);
        threadB.setName("b");
        threadB.start();


    }


}
