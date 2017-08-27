package com.chen.designPattern.abstractFactory;

/**
 * 空调具体产品2
 * @Author chenweijie
 * @Date 2017/8/27 2:21
 */
public class ContainerBMW520 implements Container {

    public ContainerBMW520() {
        build();
    }

    @Override
    public void build() {
        System.out.println("我是530 空调");
    }
}
