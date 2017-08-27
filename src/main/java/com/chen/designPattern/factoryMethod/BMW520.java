package com.chen.designPattern.factoryMethod;

/**
 * 具体产品类2
 *
 * @Author chenweijie
 * @Date 2017/8/27 1:57
 */
public class BMW520 implements BMW {

    public String name = "BMW520";

    public BMW520() {
        buildBWM();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void buildBWM() {
        System.out.println("我是" + this.name);
    }
}
