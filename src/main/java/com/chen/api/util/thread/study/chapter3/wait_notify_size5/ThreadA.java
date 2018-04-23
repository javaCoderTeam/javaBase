package com.chen.api.util.thread.study.chapter3.wait_notify_size5;

/**
 * @author :  chen weijie
 * @Date: 2018-04-24 00:39
 */
public class ThreadA extends Thread {


    private Object object;

    public ThreadA(Object object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {

        synchronized (object) {
            try {
                if (MyList.size() != 5) {
                    System.out.println("wait begin..." + System.currentTimeMillis());
                    object.wait();
                    System.out.println("wait end..." + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


    }


}
