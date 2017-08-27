package com.chen.designPattern.factoryMethod;

/**
 * 具体产品类1
 * @Author chenweijie
 * @Date 2017/8/27 1:54
 */
public class BMW320 implements BMW {

    public String name ="BMW320";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BMW320() {
        buildBWM();
    }

    @Override
    public void buildBWM() {
        System.out.println("我是"+this.name);
    }
}
