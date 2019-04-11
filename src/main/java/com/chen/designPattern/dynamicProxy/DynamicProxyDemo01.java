package com.chen.designPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * java动态代理类demo  https://www.jianshu.com/p/6f6bb2f0ece9
 * 动态代理详解 https://www.cnblogs.com/gonjan-blog/p/6685611.html
 *
 * @author :  chen weijie
 * @Date: 2019-04-10 5:31 PM
 */
public class DynamicProxyDemo01 {


    /**
     * 接口
     */
    interface Subject {
        void request();
    }


    /**
     * 委托类
     */
    class RealSubject implements Subject {
        @Override
        public void request() {
            System.out.println("====RealSubject Request====");
        }
    }

    /**
     * 代理类的调用处理器
     */
    class ProxyHandler implements InvocationHandler {

        private Subject subject;

        public ProxyHandler(Subject subject) {
            this.subject = subject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before=======");
            //定义预处理的工作，当然你也可以根据 method 的不同进行不同的预处理工作
            Object result = method.invoke(subject, args);
            System.out.println("after==========");
            return result;
        }
    }


}
