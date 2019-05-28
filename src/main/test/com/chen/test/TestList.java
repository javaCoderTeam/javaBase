package com.chen.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :  chen weijie
 * @Date: 2019-05-16 18:14
 */
public class TestList {


    public static void main(String[] args) {


        Set<Integer> set = new HashSet<>();


        List<Integer> list = new ArrayList<>(null);

        for (Integer a : list) {
            System.out.println(a);
        }

    }


}
