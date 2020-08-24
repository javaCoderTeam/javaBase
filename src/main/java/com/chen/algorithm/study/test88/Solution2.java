package com.chen.algorithm.study.test88;

/**
 * @author :  chen weijie
 * @Date: 2020-08-19 18:04
 */
public class Solution2 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int pa = m - 1, pb = n - 1, pc = m + n - 1;
        while (pb >= 0) {
            if (pa >= 0 && nums1[pa] < nums2[pb]) {
                nums1[pc--] = nums2[pb--];
            } else {
                nums1[pc--] = nums1[pa--];
            }
        }
    }


}
