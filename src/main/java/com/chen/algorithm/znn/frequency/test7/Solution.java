package com.chen.algorithm.znn.frequency.test7;

import org.junit.Test;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * @Auther: zhunn
 * @Date: 2020/9/16 18:20
 * @Description: 整数反转
 */
public class Solution {

    public int reverse(int x) {
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

    @Test
    public void test() {
        System.out.println(reverse(123));
    }
}
