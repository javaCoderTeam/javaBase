package com.chen.designPattern.proxy.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * java动态代理实现与原理详细分析
 * <p>
 * https://blog.csdn.net/yaomingyang/article/details/80981004
 * <p>
 * https://blog.csdn.net/yaomingyang/article/details/81040390
 *
 * @author :  chen weijie
 * @Date: 2019-06-06 00:13
 */
public class WorkHandler implements InvocationHandler {


    /**
     * 代理类中真实的对象
     */
    public Object object;

    WorkHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("work before do something ");
        Object o = method.invoke(object, args);
        System.out.println("work after do something ");
        return o;
    }


}
