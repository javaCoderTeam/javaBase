package com.chen.designPattern.manyMethodFactory;

/**
 * Created by chenwj3 on 2017/1/19.
 */
public class SendFactory {


    public Sender produceMail(){
        return  new MailSender();
    }

    public Sender produceSms(){

        return  new SmsSender();
    }


}
