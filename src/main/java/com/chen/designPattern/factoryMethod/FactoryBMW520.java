package com.chen.designPattern.factoryMethod;

/**
 * 具体工厂类1
 * @Author chenweijie
 * @Date 2017/8/27 2:03
 */
public class FactoryBMW520 implements FactoryBMW {

    @Override
    public BMW createBMW() {
        return new BMW520();
    }
}
