package com.chen.designPattern.modelPattern;

/**抽象模板
 *
 * https://blog.csdn.net/jason0539/article/details/45037535
 *
 * Created by Chen Weijie on 2017/8/17.
 */
public abstract class Station {


    public abstract String getName();

    public abstract void safetyExamine();

    public abstract void validateTicket();

    public abstract void choiceCarriageType();

    /**
     * 模板方法
     */
    public final void ridingStep(){

        safetyExamine();
        validateTicket();
        choiceCarriageType();
    }


}
