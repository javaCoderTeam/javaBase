package com.chen.test.strategy;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 00:38
 */
public class LowPrice implements Price {
    @Override
    public double calcPrice(Integer p) {
        return 0.2 * p;
    }
}
