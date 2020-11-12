package com.chen.algorithm.znn.frequency.test9;

import org.junit.Test;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * @Auther: zhunn
 * @Date: 2020/9/16 18:22
 * @Description: 回文数
 */
public class Solution {

    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        return res == x || res / 10 == x;
    }

    @Test
    public void test() {
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(1000));
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(1231));
    }
}
