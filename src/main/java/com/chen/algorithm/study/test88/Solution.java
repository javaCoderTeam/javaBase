package com.chen.algorithm.study.test88;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/solution/leetcode88-he-bing-liang-ge-you-xu-shu-zu-by-ma-xi/
 *
 * @author :  chen weijie
 * @Date: 2020-07-20 11:33
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
        int[] m = {0};
        int[] n = {4};
        merge(m, 0, n, n.length);

    }

}
