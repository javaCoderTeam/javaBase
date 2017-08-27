package com.chen.designPattern.factoryMethod;

/**
 * 客户类
 * @Author chenweijie
 * @Date 2017/8/27 2:05
 */
public class MainTest {

    public static void main(String[] args) {

        FactoryBMW factoryBMW320 = new FactoryBMW320();
        factoryBMW320.createBMW();


        FactoryBMW factoryBMW520 =new FactoryBMW520();
        factoryBMW520.createBMW();


    }


}
