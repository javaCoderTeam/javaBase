package com.chen.test.strategy;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 00:39
 */
public class Market {

    private Price price;

    public Market(Price price) {
        this.price = price;
    }


    /**
     * 计算价格
     *
     * @param value
     * @return
     */
    public double cacul(Integer value) {
        return price.calcPrice(value);

    }

}
