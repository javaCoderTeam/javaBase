package com.chen.designPattern.normalFactory;

/**
 * 简单工厂模式（先创建一个接口  然后创建2个实例，再创建一个工厂类）
 * 工厂类
 * Created by chenwj3 on 2017/1/19.
 */
public class SendFactory {

    public Sender produce(String type){
        if ("mail".equals(type)){
            return new MailSender();
        }else if ("sms".equals(type)){
            return  new SmsSender();
        }else {
            System.out.println("please write write type！");
            return null;
        }
    }



}
