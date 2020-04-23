package com.chen.test.strategy;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 00:36
 */
public class HignPrice implements Price {


    @Override
    public double calcPrice(Integer p) {
        return p * 0.75;
    }
}
