package com.chen.designPattern.staticFactory;

/**
 * Created by chenwj3 on 2017/1/19.
 */
public class SendFactory {


    public static Sender produceMail(){
        return  new MailSender();
    }

    public static Sender produceSms(){

        return  new SmsSender();
    }


}
