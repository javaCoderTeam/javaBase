package com.chen.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Chen WeiJie
 * @date 2019-12-31 14:52:47
 **/
public class TestStreamFilter {

    public static void main(String[] args) {


//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5).stream().filter(o -> o != 4).collect(Collectors.toList());
//        System.out.println(JSONObject.toJSONString(list));

        List<String> stringList = new ArrayList<>();
        stringList.add("test");
        stringList.add("test");

        stringList = stringList.stream().distinct().collect(Collectors.toList());

        System.out.println(JSONObject.toJSONString(stringList));




    }

}
