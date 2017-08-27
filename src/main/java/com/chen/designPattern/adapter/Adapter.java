package com.chen.designPattern.adapter;

/**
 * 适配器 (http://alexpdh.com/2017/06/24/adapter-pattern/)
 * 通过在内部包装一个适配者对象，把源接口转换成目标接口。
 *
 * @Author chenweijie
 * @Date 2017/8/27 3:01
 */
public class Adapter implements Target {

    private Adaptee adaptee;


    @Override
    public void request() {
        adaptee = new Adaptee();
        adaptee.specificRequest();

    }

}
