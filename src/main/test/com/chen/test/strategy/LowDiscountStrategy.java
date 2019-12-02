package com.chen.test.strategy;

/**
 * @author :  chen weijie
 * @Date: 2019-11-15 00:42
 */
public class LowDiscountStrategy implements PriceStrategy {

    @Override
    public double discount() {
        return 0.5;
    }
}
