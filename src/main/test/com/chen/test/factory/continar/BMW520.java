package com.chen.test.factory.continar;

/**
 * @author :  chen weijie
 * @Date: 2019-11-15 00:02
 */
public class BMW520 implements BMWFactory {

    @Override
    public Container getContainer() {
        return new ContainerB();
    }

    @Override
    public Engine getEngine() {
        return new EngineB();
    }
}
