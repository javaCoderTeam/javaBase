package com.chen.designPattern.adapter2;

/**
 * @Author chenweijie
 * @Date 2017/8/27 3:15
 */
public class Adapter implements V5Power {


    private int v220power;

    public Adapter(V220Power v220Power) {
        v220power = v220Power.provide();
    }

    @Override
    public int provideV5Power() {
        //TODO 复杂的操作
        return 5;
    }
}
