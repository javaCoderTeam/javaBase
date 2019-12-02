package com.chen.test.proxy;

/**
 * @author :  chen weijie
 * @Date: 2019-11-15 17:42
 */
public class Test {


    public static void main(String[] args) {


        Subject realSubject = new RealSubject();

        Proxy proxy = new Proxy(realSubject);

        proxy.request();


    }
}
