package com.chen.designPattern.normalFactory;

/**
 * Created by chenwj3 on 2017/1/19.
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is a mailSender");
    }
}
