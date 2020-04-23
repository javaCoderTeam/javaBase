package com.chen.test.abstractFacory;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:21
 */
public class Test {

    public static void main(String[] args) {
        BMWFactory bmw320 = new BMW320();

        BMWFactory bmw520 = new BMW520();

        bmw320.buildBMW();
        bmw520.buildBMW();


    }
}
