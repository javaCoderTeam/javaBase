package com.chen.api.util.jvm.chapter2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用cglib似的方法区出现内存溢出异常
 * <p>
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -Xss2M -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @author :  chen weijie
 * @Date: 2018-10-23 8:39 PM
 */
public class CGLibStackOverflowError {


    public static void main(String[] args) {

        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o, args);
                }
            });
            enhancer.create();
        }
    }


    static class OOMObject {

    }

}
