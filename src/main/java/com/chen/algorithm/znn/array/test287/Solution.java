package com.chen.algorithm.znn.array.test287;

import org.junit.Test;

import java.util.Arrays;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 *
 * @Auther: zhunn
 * @Date: 2020/11/08 15:25
 * @Description: 寻找重复数：1-排序迭代；2-快慢指针
 * 将i 指向 nums[i],如果有重复，就会形成环状
 */
public class Solution {

    /**
     * 1-排序迭代
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 2-快慢指针
     *
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    @Test
    public void test() {
        int[] nums = {1, 6, 7, 7, 7, 2, 3, 5};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicate2(nums));
    }
}
