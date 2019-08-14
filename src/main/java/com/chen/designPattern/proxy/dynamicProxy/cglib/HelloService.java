package com.chen.designPattern.proxy.dynamicProxy.cglib;

/**
 * @author :  chen weijie
 * @Date: 2019-06-07 18:20
 */
public class HelloService {


    public HelloService() {
        System.out.println("HelloService构造");
    }

    /**
     * 该方法不能被子类覆盖,Cglib是无法代理final修饰的方法的
     */
    final public String sayOthers(String name) {
        System.out.println("HelloService:sayOthers>>" + name);
        return null;
    }


    public void sayHello() {
        System.out.println("HelloService:sayHello");
    }

}
