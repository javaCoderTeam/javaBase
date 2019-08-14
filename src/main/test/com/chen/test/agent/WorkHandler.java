package com.chen.test.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author :  chen weijie
 * @Date: 2019-08-05 22:42
 */
public class WorkHandler implements InvocationHandler {


    private Object object;


    /**
     * 构造方法
     *
     * @param object
     */
    public WorkHandler(Object object) {
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("invoke before !");
        Object o = method.invoke(object, args);
        System.out.println("invoke after !");
        return o;
    }
}
