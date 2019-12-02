package com.chen.test.factory.continar;

/**
 * @author :  chen weijie
 * @Date: 2019-11-15 00:01
 */
public class BMW320 implements BMWFactory {

    @Override
    public Container getContainer() {
        ContainerA containerA = new ContainerA();
        containerA.printContainerName();
        return containerA;
    }

    @Override
    public Engine getEngine() {
        EngineA engineA = new EngineA();
        engineA.printEngineName();
        return engineA;
    }
}
