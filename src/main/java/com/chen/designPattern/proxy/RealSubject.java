package com.chen.designPattern.proxy;

/**
 * 是原对象（本文把原对象称为"委托对象"）
 * @Author chenweijie
 * @Date 2017/8/27 4:02
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("我是原对象");
    }
}
