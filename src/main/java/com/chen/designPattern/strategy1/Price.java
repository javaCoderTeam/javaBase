package com.chen.designPattern.strategy1;

/**
 * 价格类
 *
 * @Author chenweijie
 * @Date 2017/8/27 3:41
 */
public class Price {

    //持有一个具体策略对象

    private MemberStrategy strategy;

    public Price(MemberStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 计算图书的价格
     *
     * @param price 图书的原价格
     * @return 图书打折后的价格
     */
    public double quota(double price) {

        return this.strategy.calcPrice(price);
    }


}
