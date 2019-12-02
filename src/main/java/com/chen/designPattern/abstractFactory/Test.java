package com.chen.designPattern.abstractFactory;

/**
 * 抽象工厂类 https://blog.csdn.net/jason0539/article/details/44976775
 *
 * 抽象工厂和工厂方法模式  https://blog.csdn.net/Olive_ZT/article/details/78861388
 *
 * @Author chenweijie
 * @Date 2017/8/27 2:27
 */
public class Test {

    public static void main(String[] args) {

        FactoryBMW bmw320 = new BMW320();
        bmw320.getContainer();
        bmw320.getEngine();

        FactoryBMW bmw520 = new BMW520();
        bmw520.getContainer();
        bmw520.getEngine();


    }
}
