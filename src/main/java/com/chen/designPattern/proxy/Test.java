package com.chen.designPattern.proxy;

/**
 * https://www.cnblogs.com/daniels/p/8242592.html
 *
 * @author :  chen weijie
 * @Date: 2020-04-21 02:03
 */
public class Test {

    public static void main(String[] args) {

        Proxy proxy = new Proxy(new BuyHouseImpl());

        proxy.buyHouse();


    }

}
