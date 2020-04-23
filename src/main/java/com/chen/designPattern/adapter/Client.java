package com.chen.designPattern.adapter;

/**
 * https://blog.csdn.net/jason0539/article/details/22468457
 * @author :  chen weijie
 * @Date: 2020-04-21 01:43
 */
public class Client {

    public static void main(String[] args) {

        StardMethod stardMethod = new Adapter();
        stardMethod.request();

    }
}
