package com.chen.designPattern.normalFactory;

/**
 * 客户类
 * Created by chenwj3 on 2017/1/19.
 */
public class Main {

    public static void main(String args[]) {

        SendFactory sendFactory = new SendFactory();
        Sender sender = sendFactory.produce("mail");
        sender.send();

        Sender sender1 =ClassForNameFactory.getInstance("com.ifeng.chen.designPattern.normalFactory.SmsSender");
        sender1.send();


    }


}
