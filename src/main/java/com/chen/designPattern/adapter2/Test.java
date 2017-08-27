package com.chen.designPattern.adapter2;

/**
 * 测试类
 *
 * @Author chenweijie
 * @Date 2017/8/27 3:21
 */
public class Test {

    public static void main(String[] args) {
        Mobile mobile = new Mobile();

        V5Power v5Power = new Adapter(new V220Power());
        mobile.inputPower(v5Power);

    }


}
