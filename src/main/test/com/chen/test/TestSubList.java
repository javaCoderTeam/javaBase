package com.chen.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2019-05-08 18:45
 */
public class TestSubList {

    public static void main(String[] args) {


        Integer[] integers = {1, 2, 3, 4, 5, 6};

        List<Integer> integerList = Arrays.asList(integers);

        List<Integer> integers1 = integerList.subList(3, 4);


        System.out.println(integers1);



    }



}
