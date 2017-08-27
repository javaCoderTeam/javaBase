package com.chen.designPattern.strategy1;

/** 高级会员的折扣
 * @Author chenweijie
 * @Date 2017/8/27 3:40
 */
public class AdvancedMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double price) {

        return price * 0.6;
    }
}
