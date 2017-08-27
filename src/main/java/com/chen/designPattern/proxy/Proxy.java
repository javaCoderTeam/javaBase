package com.chen.designPattern.proxy;

/**
 * 代理模式 （http://www.jianshu.com/p/6f6bb2f0ece9）
 * 代理
 *
 * @Author chenweijie
 * @Date 2017/8/27 3:58
 */
public class Proxy implements Subject {

    private Subject subject;


    @Override
    public void request() {
        System.out.println("PreProcess");
        subject.request();
        System.out.println("PostProcess");
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
