package com.chen.designPattern.strategy1;

/**
 * 测试类
 *
 * @Author chenweijie
 * @Date 2017/8/27 3:44
 */
public class TestMain {

    public static void main(String[] args) {

        Price price = new Price(new AdvancedMemberStrategy());
        double d = price.quota(300);
        System.out.println(d);

    }

}
