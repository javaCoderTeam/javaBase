package com.chen.test.agent;

import java.lang.reflect.Proxy;

/**
 * @author :  chen weijie
 * @Date: 2019-08-05 22:45
 */
public class Test {


    public static void main(String[] args) {


        People teacher = new Teacher();


        WorkHandler workHandler = new WorkHandler(teacher);

        People proxyInstance = (People) Proxy.newProxyInstance(teacher.getClass().getClassLoader(), teacher.getClass().getInterfaces(), workHandler);
        proxyInstance.work();

    }


}
