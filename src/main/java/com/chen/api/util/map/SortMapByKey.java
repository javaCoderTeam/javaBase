package com.chen.api.util.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by chenwj3 on 2017/1/18.
 */
public class SortMapByKey {


    public static Map<String, Integer> sortMapByKey(Map<String, Integer> map) {

        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, Integer> sortMap = new TreeMap<>(new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }

}
