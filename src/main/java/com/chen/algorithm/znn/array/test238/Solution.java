package com.chen.algorithm.znn.array.test238;

import com.alibaba.fastjson.JSON;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * @Auther: zhunn
 * @Date: 2020/10/16 14:30
 * @Description: 除自身以外数组的乘积
 */
public class Solution {

    /**
     * 时间复杂度O(N)，空间复杂度O(N)
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int length = nums.length;

        // left和right 分别表示左右两侧的乘积列表
        int[] left = new int[length];
        int[] right = new int[length];

        int[] answer = new int[length];

        // left[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 ‘0’ 的元素，因为左侧没有元素，所以left[0]=1
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // right[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 ‘length-1’ 的元素，因为右侧没有元素，所以right[length - 1] = 1
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // 对于索引i，除nums[i]之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = left[i] * right[i];
        }
        return answer;
    }

    /**
     * 时间复杂度O(N)，空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    //public static int[] productExceptSelf1(int[] nums) {
    //    if (nums == null || nums.length == 0) {
    //        return new int[0];
    //    }
    //
    //    int length = nums.length;
    //    int[] answer = new int[length];
    //
    //    // answer[i] 为索引 i 左侧所有元素的乘积
    //    // 对于索引为 ‘0’ 的元素，因为左侧没有元素，answer[0]=1
    //    answer[0] = 1;
    //    for (int i = 1; i < length; i++) {
    //        answer[i] = answer[i - 1] * nums[i - 1];
    //    }
    //
    //    // right 为右侧所有元素的乘积
    //    // 刚开始右侧没有元素，所以right = 1
    //    int right = 1;
    //    for (int i = length - 1; i >= 0; i--) {
    //        // 对于索引 i，左边的乘积为answer[i],右边的乘积为right
    //        answer[i] = right * answer[i];
    //        // right 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 right 上
    //        right = right * nums[i];
    //    }
    //    return answer;
    //}
    public static int[] productExceptSelfTest(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int length = nums.length;
        int[] answer = new int[length];

        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = right * answer[i];
            right = right * nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2};
        System.out.println(JSON.toJSONString(productExceptSelf(nums)));
    }

}
