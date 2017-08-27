package com.chen.designPattern.adapter;

/**
 * 测试类
 *
 * @Author chenweijie
 * @Date 2017/8/27 3:05
 */
public class TestMain {

    public static void main(String[] args) {

        Target target = new Adapter();
        target.request();

    }

}
