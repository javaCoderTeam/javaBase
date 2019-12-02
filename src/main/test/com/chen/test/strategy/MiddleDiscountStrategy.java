package com.chen.test.strategy;

/**
 * @author :  chen weijie
 * @Date: 2019-11-15 00:41
 */
public class MiddleDiscountStrategy implements PriceStrategy {

    @Override
    public double discount() {
        return 0.75;
    }
}
