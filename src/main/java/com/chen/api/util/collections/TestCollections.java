package com.chen.api.util.collections;

import java.util.*;

/**
 * Created by chenwj3 on 2017/3/9.
 */
public class TestCollections {

    public static void main(String [] args){

        String date1="2017-03-09";
        String date2="2017-03-10";
        String date3="2017-02-28";

        List<String> list=new ArrayList<>();
        int code = Objects.hashCode(list);
        System.out.println("============="+code);
        list.add(date1);
        list.add(date2);
        list.add(date3);

        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));


    }


}
