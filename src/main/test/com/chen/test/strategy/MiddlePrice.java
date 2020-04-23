package com.chen.test.strategy;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 00:37
 */
public class MiddlePrice implements Price {

    @Override
    public double calcPrice(Integer p) {
        return 0.5 * p;
    }
}
