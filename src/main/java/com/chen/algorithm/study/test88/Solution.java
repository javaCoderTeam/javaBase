package com.chen.algorithm.study.test88;

import org.junit.Test;

import java.util.Arrays;

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
        int[] m = {1,2,3,0,0,0};
        int[] n = {2,5,6};
        merge(m, 3, n, n.length);
        System.out.println(Arrays.toString(m));

    }

}
