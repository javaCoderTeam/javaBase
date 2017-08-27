package com.chen.designPattern.adapter;

/**
 * 适配者
 * 需要适配的类。
 * @Author chenweijie
 * @Date 2017/8/27 3:00
 */
public class Adaptee {

    public void specificRequest(){

        System.out.println("特殊的请求！");
    }
}
