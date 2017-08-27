package com.chen.designPattern.strategy1;

/**
 *  初级会员
 * @Author chenweijie
 * @Date 2017/8/27 3:38
 */
public class PrimaryMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double price) {

        return price;
    }
}
