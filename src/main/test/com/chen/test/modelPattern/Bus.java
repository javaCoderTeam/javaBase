package com.chen.test.modelPattern;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:50
 */
public class Bus extends Station {
    @Override
    void safetyCheck() {
        System.out.println("bus safetyCheck");
    }

    @Override
    void ticketCheck() {
        System.out.println("bus ticketCheck");
    }

    @Override
    void cabageCheck() {
        System.out.println("bus cabageCheck");
    }
}
