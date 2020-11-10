package com.chen.algorithm.znn.array.test88;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/solution/leetcode88-he-bing-liang-ge-you-xu-shu-zu-by-ma-xi/
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明：
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例：
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * @author: zhunn
 * @Date: 2020-10-20 11:33
 * @Description: 合并两个有序数组
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1, p2 = n - 1, p3 = m + n - 1;
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p3--] = nums1[p1--];
            } else {
                nums1[p3--] = nums2[p2--];
            }
        }
    }


    @Test
    public void testCase() {
        //int[] m = {1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0};
        //int[] n = {0, 2, 5, 6, 8, 9, 25};
        //merge(m, 4, n, n.length);
        int[] m = {1, 2, 3, 0, 0, 0};
        int[] n = {2, 5, 6};
        merge(m, 3, n, n.length);
        System.out.println(Arrays.toString(m));
    }

}
