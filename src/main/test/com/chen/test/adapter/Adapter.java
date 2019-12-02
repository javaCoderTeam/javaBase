package com.chen.test.adapter;

/**
 * @author :  chen weijie
 * @Date: 2019-11-15 00:17
 */
public class Adapter implements Target {


    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {

        adaptee.specialRequest();
    }


}
