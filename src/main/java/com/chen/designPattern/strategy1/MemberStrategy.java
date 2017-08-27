package com.chen.designPattern.strategy1;

/**
 * 抽象折扣类 （http://www.cnblogs.com/java-my-life/archive/2012/05/10/2491891.html）
 * @Author chenweijie
 * @Date 2017/8/27 3:35
 */
public interface  MemberStrategy {

    /**
     * 计算图书的价格
     * @param price 图书的原价
     * @return 打折后的价格
     */
    double calcPrice(double price);

}
