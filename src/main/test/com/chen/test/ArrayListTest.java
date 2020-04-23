package com.chen.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

/**
 * @author :  chen weijie
 * @Date: 2020-04-12 11:26
 */
public class ArrayListTest {


    public static void main(String[] args) {


        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        System.out.printf("Before add:arrayList.size() = %d\n", arrayList.size());
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(9);


        Integer[] arrays = arrayList.toArray(new Integer[0]);


        Integer[] arrays2 = new Integer[arrayList.size()];

        arrays2 = arrayList.toArray(arrays2);

        System.out.println(JSONObject.toJSONString(arrays2));


    }

}
