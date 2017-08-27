package com.chen.designPattern.abstractFactory;

/**
 * 具体产品类1
 * @Author chenweijie
 * @Date 2017/8/27 2:16
 */
public class BMW320Engine implements Engine {


    public BMW320Engine(){
        create();
    }

    @Override
    public void create() {

        System.out.println("我是320 引擎");
    }

}
