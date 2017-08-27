package com.chen.designPattern.abstractFactory;

/**
 * BMW320 产品
 * @Author chenweijie
 * @Date 2017/8/27 2:26
 */
public class BMW320 implements FactoryBMW {

    @Override
    public Container getContainer() {
        return new ContainerBMW320();
    }

    @Override
    public Engine getEngine() {
        return new BMW320Engine();
    }
}
