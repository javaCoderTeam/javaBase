package com.chen.designPattern.adapter2;

/**
 * 手机
 *
 * @Author chenweijie
 * @Date 2017/8/27 3:11
 */
public class Mobile {

    public void inputPower(V5Power v5Power) {

        int power = v5Power.provideV5Power();

        System.out.println("我需要的是5V的电压，现在是" + power);


    }

}
