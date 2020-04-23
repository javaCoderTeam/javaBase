package com.chen.test.factoryMethod;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:05
 */
public class BMW520Factory implements  BMWFactory {


    @Override
    public BMW buildBMW() {
        return new BMW320("bmw520");
    }
}
