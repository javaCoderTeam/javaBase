package com.chen.algorithm.znn.array.test561;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/array-partition-i/solution/shu-zu-chai-fen-i-by-leetcode/
 * 给定长度为2n的整数数组 nums ，你的任务是将这些数分成n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到n 的 min(ai, bi) 总和最大。
 * 返回该 最大总和 。
 * 示例 1：
 * 输入：nums = [1,4,3,2]
 * 输出：4
 * 解释：所有可能的分法（忽略元素顺序）为：
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * 所以最大总和为 4
 *
 * @Auther: zhunn
 * @Date: 2020/11/5 18:46
 * @Description: 数组拆分 I
 */
public class Solution {

    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //初始一个结果
        int sum = 0;
        //对数组进行升序排序
        Arrays.sort(nums);
        //循环数组，选择索引为0、2、4、6、8...这样可以保证获取每两个元素的最小值
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i]; //将最小值加起来
        }
        return sum;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));
    }
}
