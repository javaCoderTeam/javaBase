package com.chen.api.util.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理处理类
 *
 * @author Chen WeiJie
 * @date 2017-12-22 14:17
 **/
public class DynamicProxyHandler implements InvocationHandler {


    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().startsWith("do")) {
            System.out.println("call do*** method");
        }

        method.invoke(proxied, args);

        return null;
    }


}
