package com.chen.test.modelPattern;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:51
 */
public class Test {

    public static void main(String[] args) {

        Station subway = new Subway();
        subway.play();

        Station bus = new Bus();
        bus.play();

    }

}
