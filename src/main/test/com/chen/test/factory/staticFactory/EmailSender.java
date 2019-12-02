package com.chen.test.factory.staticFactory;

/**
 * @author :  chen weijie
 * @Date: 2019-11-14 23:21
 */
public class EmailSender implements Sender {

    @Override
    public void send() {

        System.out.println("email sender");
    }
}
