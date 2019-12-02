package com.chen.test.factory.staticFactory;

/**
 * @author :  chen weijie
 * @Date: 2019-11-14 23:22
 */
public class SmsSender implements Sender {


    @Override
    public void send() {

        System.out.println("sms sender");
    }
}
