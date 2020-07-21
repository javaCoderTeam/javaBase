package com.chen.api.util.thread.study.chapter4.readWriteLockBegin2;


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
                service.write();
            }
        };


        for (int i = 0; i < 10; i++) {
            Thread threadA = new Thread(runnable);
            threadA.setName("a." + i);
            threadA.start();
            Thread threadB = new Thread(runnable);
            threadB.setName("b." + i);
            threadB.start();
        }





    }


}
