package com.chen.test.staticFactory;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 00:54
 */
public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("mail sender");
    }
}
