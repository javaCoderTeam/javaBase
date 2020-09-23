package com.chen.algorithm.study.test415;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author :  chen weijie
 * @Date: 2020-09-23 17:01
 */
public class Solution36 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        String r = addStrings(str1, str2);
        System.out.println(r);
    }

    public static String addStrings(String num1, String num2) {

        if (num1 == null) {
            return num2;
        }

        if (num2 == null) {
            return num1;
        }

        Character[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        List<Character> list = Arrays.asList(chars);


        int add = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || add > 0) {

            if (i >= 0) {
                char c = num1.charAt(i);
                add += list.indexOf(c);
                i--;
            }

            if (j >= 0) {
                char c = num2.charAt(j);
                add += list.indexOf(c);
                j--;
            }

            sb.append(list.get(add % 36));
            add = add / 36;
        }


        return sb.reverse().toString();
    }
}
