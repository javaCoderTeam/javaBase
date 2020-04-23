package com.chen.test.factoryMethod;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:01
 */
public class BMW320 implements BMW {

    private String bmwName;

    public BMW320(String bmwName) {
        this.bmwName = bmwName;
    }


    @Override
    public void buildBMW() {
        System.out.println("build:" + this.bmwName);
    }
}
