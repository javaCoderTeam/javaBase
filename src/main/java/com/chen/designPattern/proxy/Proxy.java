package com.chen.designPattern.proxy;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 02:01
 */
public class Proxy implements BuyHouse {


    private BuyHouse buyHouse;

    public Proxy(BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHouse() {
        System.out.println("买房前准备");
        buyHouse.buyHouse();
        System.out.println("买房后装修");

    }
}
