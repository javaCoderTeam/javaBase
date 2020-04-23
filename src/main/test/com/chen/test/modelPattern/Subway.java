package com.chen.test.modelPattern;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:51
 */
public class Subway extends Station {

    @Override
    void safetyCheck() {
        System.out.println("Subway safetyCheck");
    }

    @Override
    void ticketCheck() {
        System.out.println("Subway ticketCheck");
    }

    @Override
    void cabageCheck() {
        System.out.println("Subway cabageCheck");
    }
}
