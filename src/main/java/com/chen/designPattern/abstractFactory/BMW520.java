package com.chen.designPattern.abstractFactory;

/**
 * BMW520 产品
 * @Author chenweijie
 * @Date 2017/8/27 2:24
 */
public class BMW520 implements FactoryBMW {

    @Override
    public Container getContainer() {
        return new ContainerBMW520();
    }

    @Override
    public Engine getEngine() {
        return new BMW520Engine();
    }
}
