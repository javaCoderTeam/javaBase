package com.chen.designPattern.factoryMethod;

/**
 * 具体工厂类
 *
 * @Author chenweijie
 * @Date 2017/8/27 2:05
 */
public class FactoryBMW320 implements FactoryBMW {

    @Override
    public BMW createBMW() {
        return new BMW320();
    }
}
