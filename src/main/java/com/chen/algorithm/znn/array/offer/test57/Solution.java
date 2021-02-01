package com.chen.algorithm.znn.array.offer.test57;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
 * 剑指 Offer 57 - II. 和为s的连续正数序列：
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * @Auther: zhunn
 * @Date: 2020/11/08 15:25
 * @Description: 剑指 Offer 57 - II. 和为s的连续正数序列：滑动窗口法
 */
public class Solution {

    //public int[][] findContinuousSequence(int target) {
    //    int i = 1; // 滑动窗口的左边界
    //    int j = 1; // 滑动窗口的右边界
    //    int sum = 0; // 滑动窗口中数字的和
    //    List<int[]> res = new ArrayList<>();
    //
    //    while (i <= target / 2) {
    //        if (sum < target) {
    //            // 右边界向右移动
    //            sum += j;
    //            j++;
    //        } else if (sum > target) {
    //            // 左边界向右移动
    //            sum -= i;
    //            i++;
    //        } else {
    //            // 记录结果
    //            int[] arr = new int[j - i];
    //            for (int k = i; k < j; k++) {
    //                arr[k - i] = k;
    //            }
    //            res.add(arr);
    //            // 左边界向右移动
    //            sum -= i;
    //            i++;
    //        }
    //    }
    //
    //    return res.toArray(new int[res.size()][]);
    //}

    /**
     * 滑动窗口法
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();

        while (left <= target / 2) { // 假设窗口左边界i=target/2, i+1=target/2 +1,那么i + (i+1) = target+1,即最小的窗口的元素之和就已经比target大了，所以当i>=target/2时不可能有一个窗口长度>=2的答案。 这也归因于本题的特殊要求：答案数组至少包含两个元素。 如果没有上述要求，那么在i>=target/2的范围内还存在当i == target时的结果，窗口长度==1。
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] arr = new int[right - left];
                for (int i = left; i < right; i++) {
                    arr[i - left] = i;
                }
                res.add(arr);

                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(findContinuousSequence(15)));
    }
}
