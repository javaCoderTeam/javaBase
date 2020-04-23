package com.chen.test.strategy;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 00:39
 */
public class Test {

    public static void main(String[] args) {


        Market market = new Market(new HignPrice());

        double d = market.cacul(100);

        System.out.println(d);


    }
}
