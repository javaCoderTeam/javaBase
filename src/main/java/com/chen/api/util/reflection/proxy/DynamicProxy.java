package com.chen.api.util.reflection.proxy;


import java.lang.reflect.Proxy;

/**
 * 动态代理Main
 *
 * @author Chen WeiJie
 * @date 2017-12-22 14:21
 **/
public class DynamicProxy {

    public static void main(String[] args) {
        RealObject proxied = new RealObject();
        proxied.doSomething();
        proxied.doSomethingElse("chenweijie");

        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class
                .getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(proxied));
        proxy.doSomething();
        proxy.doSomethingElse("chenweijie");

    }

}
