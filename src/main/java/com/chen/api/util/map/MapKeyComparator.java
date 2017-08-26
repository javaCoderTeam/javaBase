package com.chen.api.util.map;

import java.util.Comparator;

/**
 * Created by chenwj3 on 2017/1/18.
 */
public class MapKeyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
