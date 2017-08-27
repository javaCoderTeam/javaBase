package com.chen.designPattern.staticFactory;

/**
 * 具体产品类1
 * Created by chenwj3 on 2017/1/19.
 */
public class SmsSender implements Sender {

    @Override
    public void send() {
        System.out.println("this is a SmsSender!");
    }
}
