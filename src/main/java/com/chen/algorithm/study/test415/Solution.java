package com.chen.algorithm.study.test415;

/**
 * @author :  chen weijie
 * @Date: 2020-09-23 17:01
 */
public class Solution {

    public String addStrings(String num1, String num2) {

        if (num1 == null) {
            return num2;
        }

        if (num2 == null) {
            return num1;
        }

        int add = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || add > 0) {

            if (i >= 0) {
                add += num1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                add += num2.charAt(j) - '0';
                j--;
            }

            sb.append(add % 10);
            add = add / 10;
        }


        return sb.reverse().toString();
    }
}
