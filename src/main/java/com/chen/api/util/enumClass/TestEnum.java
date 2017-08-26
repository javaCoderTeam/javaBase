package com.chen.api.util.enumClass;

/**
 * Created by Chen Weijie on 2017/7/17.
 */
public class TestEnum {

    public static void main(String[] args) {

        Code[] values = Code.values();

        for (Code code : values) {
            System.out.println(code.getName());
        }


    }
}
