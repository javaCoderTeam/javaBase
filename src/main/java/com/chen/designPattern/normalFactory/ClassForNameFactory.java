package com.chen.designPattern.normalFactory;

/**
 * Created by Chen Weijie on 2017/8/5.
 */
public class ClassForNameFactory {


    public static Sender getInstance(String name){

        Sender sender =null;
        try {
            sender=(Sender)Class.forName(name).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sender;


    }

}
