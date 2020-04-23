package com.chen.test.staticFactory;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 00:56
 */
public class Test {

    public static void main(String[] args) {

        Sender mailSender = SendFactory.getMailSender();
        mailSender.send();

        Sender smsSender = SendFactory.getSmsSender();
        smsSender.send();


    }
}
