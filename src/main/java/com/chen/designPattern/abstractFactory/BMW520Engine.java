package com.chen.designPattern.abstractFactory;

/** 具体产品类
 * @Author chenweijie
 * @Date 2017/8/27 2:18
 */
public class BMW520Engine implements Engine {

    public BMW520Engine(){
        create();
    }

    @Override
    public void create() {
        System.out.println("我是520 引擎");
    }
}
