package com.chen.test.factoryMethod;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:06
 */
public class Test {

    public static void main(String[] args) {

        BMWFactory bmwFactory = new BMW320Factory();
        BMW bmw320 = bmwFactory.buildBMW();
        bmw320.buildBMW();

        BMWFactory bmwFactory2 = new BMW520Factory();
        BMW bmw520 = bmwFactory2.buildBMW();
        bmw520.buildBMW();
    }
}
