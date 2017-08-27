package com.chen.designPattern.abstractFactory;

/**
 * 空调具体类
 * @Author chenweijie
 * @Date 2017/8/27 2:21
 */
public class ContainerBMW320 implements Container  {

    public ContainerBMW320() {
        build();
    }

    @Override
    public void build() {
        System.out.println("我是320 空调");
    }
}
