package com.chen.designPattern.proxy.dynamicProxy.jdk;

/**
 * @author :  chen weijie
 * @Date: 2019-06-07 17:54
 */
public class Teacher implements People {

    @Override
    public String work() {
        System.out.println("老师的工作时教书！！");
        return "教书";
    }
}
