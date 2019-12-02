package com.chen.test.strategy;

/**
 * @author :  chen weijie
 * @Date: 2019-11-15 00:40
 */
public class Price {


    private PriceStrategy priceStrategy;


    public Price(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }


    public void caculatePrice() {

        double d = priceStrategy.discount();

        System.out.println("打的折扣==" + d);
    }


}
