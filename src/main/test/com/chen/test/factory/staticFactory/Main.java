package com.chen.test.factory.staticFactory;

/**
 * @author :  chen weijie
 * @Date: 2019-11-14 23:23
 */
public class Main {


    public static void main(String[] args) {

        Sender emailSender = SendFactory.getEmailSender();

        emailSender.send();


    }
}
