package com.chen.api.util.stream;

import java.util.stream.Stream;

/**
 * Created by chenwj3 on 2017/5/4.
 */
public class StreamTest2 {


    public static void main(String args[]){

        //reduce操作
        String concat= Stream.of("1","b","c").reduce("",String::concat);
        System.out.println("concat=="+concat);

        double minValue = Stream.of(1.0, 2.0, 11.0, -1.5).reduce(Double.MAX_VALUE, Double::min);
        System.out.println("minValue==" + minValue);

    }

}
