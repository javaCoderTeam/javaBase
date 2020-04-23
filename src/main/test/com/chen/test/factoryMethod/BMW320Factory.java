package com.chen.test.factoryMethod;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:06
 */
public class BMW320Factory implements BMWFactory {

    @Override
    public BMW buildBMW() {
        return new BMW320("320");
    }
}
