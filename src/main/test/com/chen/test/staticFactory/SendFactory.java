package com.chen.test.staticFactory;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 00:55
 */
public class SendFactory {


    public static Sender getMailSender() {
        return new MailSender();
    }

    public static SmsSender getSmsSender() {
        return new SmsSender();
    }


}
