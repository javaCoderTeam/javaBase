package com.chen.api.util.map;

import java.util.HashMap;
import java.util.Map;

/**
 * map按照key排序的接口
 * Created by chenwj3 on 2017/1/18.
 */
public class MapTestSort {


    public static void main(String args[]) {

        Map<String, Integer> map = new HashMap<>();
        map.put("2016-12-03", 4);
        map.put("2016-12-04", 3);
        map.put("2016-12-01", 5);
        map.put("2016-11-21", 10);
        System.out.println("map:" + map);
        Map<String, Integer> sortedMap = SortMapByKey.sortMapByKey(map);
        System.out.println("sortedMap:" + sortedMap);

    }


}
