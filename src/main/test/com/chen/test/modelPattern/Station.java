package com.chen.test.modelPattern;

/**
 * @author :  chen weijie
 * @Date: 2020-04-21 01:47
 */
public abstract class Station {


    abstract void safetyCheck();

    abstract void ticketCheck();


    abstract void cabageCheck();

    public void play() {

        safetyCheck();
        ticketCheck();
        cabageCheck();
    }


}
