package com.chen.test.factory.factorymethod;

/**
 * @author :  chen weijie
 * @Date: 2019-11-14 23:39
 */
public class Test {


    public static void main(String[] args) {

        BMW320Factory bmw320Factory = new BMW320Factory();
        BMW320 bmw320 = bmw320Factory.createBMW();
        bmw320.say();

    }
}
