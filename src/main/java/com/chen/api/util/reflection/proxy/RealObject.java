package com.chen.api.util.reflection.proxy;

/**
 * 对象
 *
 * @author Chen WeiJie
 * @date 2017-12-22 12:57
 **/
public class RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void doSomethingElse(String str) {
        System.out.println("doSomethingElse:" + str);
    }
}
