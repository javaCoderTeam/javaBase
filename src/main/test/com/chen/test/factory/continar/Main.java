package com.chen.test.factory.continar;

/**
 * @author :  chen weijie
 * @Date: 2019-11-15 00:03
 */
public class Main {

    public static void main(String[] args) {


        BMWFactory bmw320Factory = new BMW320();
        bmw320Factory.getContainer();
        bmw320Factory.getEngine();

        BMWFactory bmw520Factory = new BMW520();
        bmw520Factory.getContainer();
        bmw520Factory.getEngine();


    }

}
