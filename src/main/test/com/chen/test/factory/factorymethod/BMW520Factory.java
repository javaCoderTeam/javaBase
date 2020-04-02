package com.chen.test.factory.factorymethod;

/**
 * @author :  chen weijie
 * @Date: 2019-11-14 23:37
 */
public class BMW520Factory implements BMWFacory {

    @Override
    public BMW520 createBMW() {
        return new BMW520();
    }
}