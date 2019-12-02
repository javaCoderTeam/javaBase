package com.chen.test.proxy;

/**
 * @author :  chen weijie
 * @Date: 2019-11-15 17:40
 */
public class Proxy implements Subject {


    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }


    @Override
    public void request() {
        subject.request();
    }

}
