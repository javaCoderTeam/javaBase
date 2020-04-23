package com.chen.designPattern.adapter;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:42
 */
public class Adapter extends SpecialMethod implements StardMethod {

    @Override
    public void request() {
        super.printSpecial();
    }
}
