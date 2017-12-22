package com.chen.api.util.reflection.proxy;

/**
 * 接口
 *
 *  动态创建代理并且动态处理对所代理方法的调用。在动态代理上所做的所有调用都会被重定向到单一的调用处理器上。
 * @author Chen WeiJie
 * @date 2017-12-22 12:56
 **/
public interface Interface {

    void doSomething();

    void doSomethingElse(String str);

}
