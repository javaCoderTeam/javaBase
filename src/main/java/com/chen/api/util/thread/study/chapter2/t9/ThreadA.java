package com.chen.api.util.thread.study.chapter2.t9;

/**
 * @author chen weijie
 * @date 2018-04-16 12:54 AM
 */
public class ThreadA extends Thread {

    private MyOneList list;

    public ThreadA(MyOneList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        MyService service = new MyService();
        service.addServiceMethod(list, "A");
    }

}
