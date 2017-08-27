package com.chen.designPattern.strategy1;

/**
 * 中级会员的折扣
 *
 * @Author chenweijie
 * @Date 2017/8/27 3:39
 */
public class IntermediateMemberStrategy implements MemberStrategy {


    @Override
    public double calcPrice(double price) {

        return price * 0.75;
    }
}
