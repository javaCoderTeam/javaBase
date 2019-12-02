package com.chen.test.proxy.dynaticProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author :  chen weijie
 * @Date: 2019-11-15 18:02
 */
public class ProxyHandler<T> implements InvocationHandler {


    private T object;

    ProxyHandler(T object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke before");
        Object result = method.invoke(object, args);
        System.out.println("invoke after");
        return result;
    }
}
