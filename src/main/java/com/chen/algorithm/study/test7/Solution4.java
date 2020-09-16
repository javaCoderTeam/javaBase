package com.chen.algorithm.study.test7;

/**
 * @Auther: zhunn
 * @Date: 2020/9/16 18:20
 * @Description:
 */
public class Solution4 {

    public static int reverse1(int x) {
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse1(123));
    }
}
