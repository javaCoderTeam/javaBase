package com.chen.api.util.thread.study.chapter4.readWriteLockBegin1;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 01:39
 */
public class Run {

    public static void main(String[] args) {

        Service service = new Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.read();
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
