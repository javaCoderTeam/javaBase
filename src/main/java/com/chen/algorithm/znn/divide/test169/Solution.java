package com.chen.algorithm.znn.divide.test169;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @Auther: zhunn
 * @Date: 2020/11/2 16:23
 * @Description: 多数元素：1-排序；2-哈希表（优选）；3-分治
 */
public class Solution {

    /**
     * 1-排序
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 2-哈希表(优化后)
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
                continue;
            }

            int count = map.get(num) + 1;
            if (count > nums.length / 2) {
                return num;
            }
            map.put(num, count);
        }
        return 0;
    }

    /**
     * 2-哈希表(直观)
     *
     * @param nums
     * @return
     */
    //public int majorityElement2(int[] nums) {
    //    if (nums == null || nums.length == 0) {
    //        return 0;
    //    }
    //    Map<Integer, Integer> map = new HashMap<>();
    //    for (int i = 0; i < nums.length; i++) {
    //        if (map.containsKey(nums[i])) {
    //            int count = map.get(nums[i]) + 1;
    //            if (count > nums.length / 2) {
    //                return nums[i];
    //            }
    //            map.put(nums[i], count);
    //        } else {
    //            map.put(nums[i], 1);
    //        }
    //    }
    //    return 0;
    //}

    /**
     * 3-分治:官方解答
     *
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    @Test
    public void test() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement2(nums));
    }
}
