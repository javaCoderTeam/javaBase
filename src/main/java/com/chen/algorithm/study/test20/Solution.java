package com.chen.algorithm.study.test20;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;



/**
 * 错误
 *
 * @author :  chen weijie
 * @Date: 2019-09-05 23:10
 */
public class Solution {


    public boolean isValid(String s) {

        if (s == null) {
            return false;
        }

        if ("".equals(s)) {
            return true;
        }

        Map<String, Double> map = new HashMap<>(6);

        map.put("(", 0.3);
        map.put(")", -0.3);
        map.put("[", 3.0);
        map.put("]", -3.0);
        map.put("{", 30.0);
        map.put("}", -30.0);

        char[] chars = s.toCharArray();

        if (chars.length == 1) {
            return false;
        }

        if (chars.length % 2 != 0) {
            return false;
        }

        double count = 0;

        for (char aChar : chars) {
            count += map.get(String.valueOf(aChar));
        }

        if (count != 0) {
            return false;
        }

        int index = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (map.get(String.valueOf(chars[i])) + map.get(String.valueOf(chars[i + 1])) == 0 && ((i + 1) == chars.length / 2)) {
                index = i;
            }
        }


        double left = 0, right = 0;
        int a = index, b = index;

        for (int i = index; i < chars.length && a > 0 && b < chars.length; i++) {
            left += map.get(String.valueOf(chars[a]));
            right += map.get(String.valueOf(chars[b]));
            a = i--;
            b = i++;
        }

        return new BigDecimal(left).compareTo(new BigDecimal(right))==0;
    }


    @Test
    public void testCase() {

        System.out.println(isValid("(]"));

    }


}
