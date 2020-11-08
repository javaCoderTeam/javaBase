package com.chen.algorithm.znn.bitmap.test136;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
 *
 * @Auther: zhunn
 * @Date: 2020/11/07 17:23
 * @Description: 只出现一次的数字：1-hash表存储；2-位运算
 * 1、任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
 * 2、任何数和其自身做异或运算，结果是 0，a⊕a=0。
 * 3、异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
 */
public class Solution {

    /**
     * 2-位运算
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int single = 0;
        for (int num : nums) {
            single = single ^ num;
        }
        return single;
    }

    @Test
    public void test() {
        int[] nums = {7, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}
