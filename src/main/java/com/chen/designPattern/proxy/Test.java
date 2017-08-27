package com.chen.designPattern.proxy;

/**
 * 测试类
 *
 * @Author chenweijie
 * @Date 2017/8/27 4:04
 */
public class Test {

    public static void main(String[] args) {

        RealSubject realSubject = new RealSubject();

        Proxy proxy = new Proxy();
        proxy.setSubject(realSubject);

        proxy.request();


    }

}
