package com.chen.api.util.thread.test2;

/**
 * Created by Chen Weijie on 2017/8/6.
 */
public class Main {

    public static void main(String[] args) {
        StringBuffer stringBuffer =new StringBuffer();

        People people1 =new People("zhansan",stringBuffer);
        People people2 =new People("lisi",stringBuffer);

        people1.start();
        people2.start();




    }

}
