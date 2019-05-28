package com.chen.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2019-05-14 21:35
 */
public class TestCompare {


    public static void main(String[] args) {


        List<Integer> listA =new ArrayList<>();
        listA.add(1);
        listA.add(2);
        listA.add(3);


        List<Integer> listB =new ArrayList<>();
        listA.add(6);
        listA.add(5);
        listA.add(4);


        listA.addAll(listB);


//        for (int i = 0; i < listA.size(); i++) {
//            System.out.println(listA.get(i));
//        }



        double shouldNum = (double) 10 / 3;
        System.out.println(shouldNum);
        int num = (int) Math.ceil(shouldNum);
        System.out.println(num);




    }

}
