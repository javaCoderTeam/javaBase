package com.chen.designPattern.modelPattern;

/**
 * 模板方法的使用
 * Created by Chen Weijie on 2017/8/17.
 */
public class Application {


    public static void main(String[] args) {

        Station autoStation = new AutoStation();
        Station railWayStation = new RailwayStation();
        autoStation.ridingStep();
        railWayStation.ridingStep();
    }

}
