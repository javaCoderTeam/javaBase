package com.chen.algorithm.study.test9;

/**
 * @Auther: zhunn
 * @Date: 2020/9/16 18:22
 * @Description:
 */
public class Solution4 {

    public static boolean isPalindrome1(int x) {
        // 特殊情况：
        // 当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        return rev == x || rev / 10 == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome1(-121));
        System.out.println(isPalindrome1(0));
        System.out.println(isPalindrome1(1000));
        System.out.println(isPalindrome1(12321));
        System.out.println(isPalindrome1(1221));
        System.out.println(isPalindrome1(1231));
    }
}
