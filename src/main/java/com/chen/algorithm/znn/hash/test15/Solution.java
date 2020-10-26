package com.chen.algorithm.znn.hash.test15;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: zhunn
 * @Date: 2020/10/26 14:35
 * @Description: 三数之和：排序+双指针
 */
public class Solution {

    /**
     * 官方解法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    //public List<List<Integer>> threeSum(int[] nums) {
    //    int n = nums.length;
    //    Arrays.sort(nums);
    //    List<List<Integer>> ans = new ArrayList<>();
    //    for (int first = 0; first < n; ++first) {
    //        if (first > 0 && nums[first] == nums[first - 1]) {
    //            continue;
    //        }
    //        int third = n - 1;
    //        int target = -nums[first];
    //        for (int second = first + 1; second < n; ++second) {
    //            if (second > first + 1 && nums[second] == nums[second - 1]) {
    //                continue;
    //            }
    //            while (second < third && nums[second] + nums[third] > target) {
    //                --third;
    //            }
    //            if (second == third) {
    //                break;
    //            }
    //            if (nums[second] + nums[third] == target) {
    //                List<Integer> list = new ArrayList<>();
    //                list.add(nums[first]);
    //                list.add(nums[second]);
    //                list.add(nums[third]);
    //                ans.add(list);
    //            }
    //        }
    //    }
    //    return ans;
    //}

    /**
     * 推荐此方法，方便记忆
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) { // 第一个数大于0，后面的数是递增的，不会有等于0的组合，直接返回结果
                return ans;
            }
            if (i > 0 && nums[i] == nums[i - 1]) { // 去重
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) { // 去重
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) { // 去重
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] arrayNum = {-1, 0, 1, 4, 2, -1, -4};
        List<List<Integer>> result = threeSum2(arrayNum);
        System.out.println(result);
    }
}
