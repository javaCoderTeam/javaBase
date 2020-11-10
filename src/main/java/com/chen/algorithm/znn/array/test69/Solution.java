package com.chen.algorithm.znn.array.test69;

import org.junit.Test;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *
 * @author: zhunn
 * @Date: 2020-10-03 09:39
 * @Description: x的平方根，舍弃小数
 */
public class Solution {


    public int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        int left = 1, right = x / 2, mid;
        long result;

        while (right >= left) {
            mid = (right - left) / 2 + left;
            result = (long) mid * mid;
            if (result > x) {
                right = mid - 1;
            } else if (result < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }

    @Test
    public void test() {
        System.out.println(mySqrt(2147395599));
    }

}
