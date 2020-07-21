package com.chen.api.util.thread.study.chapter4.readWriteLockBegin3;

/**
 * @author :  chen weijie
 * @Date: 2018-05-21 01:54
 */
public class Run {

    public static void main(String[] args) {

        Service service = new Service();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                service.read();
            }
        };

        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                service.write();
            }
        };


        for (int i = 0; i < 10; i++) {
            Thread threadA = new Thread(readTask);
            threadA.setName("a." + i);
            threadA.start();
            Thread threadB = new Thread(writeTask);
            threadB.setName("b." + i);
            threadB.start();
        }



    }


}
