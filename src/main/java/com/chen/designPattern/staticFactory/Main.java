package com.chen.designPattern.staticFactory;


/**
 * 客户类
 * Created by chenwj3 on 2017/1/19.
 */
public class Main {

    public static void main(String args[]){

        Sender sender1= SendFactory.produceMail();
        sender1.send();
    }

}
