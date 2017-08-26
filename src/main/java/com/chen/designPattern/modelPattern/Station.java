package com.chen.designPattern.modelPattern;

/**
 * Created by Chen Weijie on 2017/8/17.
 */
public abstract class Station {


    public abstract String getName();

    public abstract void safetyExamine();

    public abstract void validateTicket();

    public abstract void choiceCarriageType();

    public final void ridingStep(){

        safetyExamine();
        validateTicket();
        choiceCarriageType();
    }


}
