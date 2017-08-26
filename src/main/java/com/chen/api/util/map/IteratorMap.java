package com.chen.api.util.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by chenwj3 on 2017/2/20.
 */
public class IteratorMap {


    public static void main(String args[]) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 101);
        map.put(2, 202);
        map.put(3, 303);
        map.put(4, 404);

        Set<Integer> set = map.keySet();

        for (Integer key : set) {
            System.out.println("key:" + key + "value:" + map.get(key));
        }


        System.out.println("==========================");


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key:" + key + "value:" + value);

        }


    }

}
