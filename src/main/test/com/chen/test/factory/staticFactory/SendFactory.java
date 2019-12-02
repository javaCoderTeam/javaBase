package com.chen.test.factory.staticFactory;

/**
 * @author :  chen weijie
 * @Date: 2019-11-14 23:22
 */
public class SendFactory {


    public static EmailSender getEmailSender(){
        return new EmailSender();
    }


    public static SmsSender getSmsSender(){
        return new SmsSender();
    }


}
