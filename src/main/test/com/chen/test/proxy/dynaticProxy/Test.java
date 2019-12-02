package com.chen.test.proxy.dynaticProxy;

import java.lang.reflect.Proxy;

/**
 * @author :  chen weijie
 * @Date: 2019-11-15 18:06
 */
public class Test {

    public static void main(String[] args) {


        People teacher = new Teacher();
        ProxyHandler proxyHandler = new ProxyHandler(teacher);
        People proxyPeople = (People) Proxy.newProxyInstance(teacher.getClass().getClassLoader(), teacher.getClass().getInterfaces(), proxyHandler);
        proxyPeople.work();

    }


}
