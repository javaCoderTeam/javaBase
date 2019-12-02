package com.chen.test.strategy;

/**
 * @author :  chen weijie
 * @Date: 2019-11-15 00:45
 */
public class Test {


    public static void main(String[] args) {


        Price price = new Price(new MiddleDiscountStrategy());

        price.caculatePrice();


    }


}
