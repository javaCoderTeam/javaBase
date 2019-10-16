package com.chen.algorithm.study.test4;

/**
 * https://blog.csdn.net/chen_xinjia/article/details/69258706
 *
 * @author :  chen weijie
 * @Date: 2019-09-07 23:08
 */
public class Solution2 {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int MIN_VALUE = 0x80000000;
        int MAX_VALUE = 0x7fffffff;


        int N1 = nums1.length;
        int N2 = nums2.length;
        // 确保N1是短的部分。
        if (N1 > N2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        if (N1 == 0) {
            return ((double) nums2[(N2 - 1) / 2] + (double) nums2[N2 / 2]) / 2;
        }

        int size = N1 + N2;
        int cutL = 0, cutR = N1;
        int cut1 = N1 / 2;


        int cut2;

        while (cut1 <= N1) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = size / 2 - cut1;

            double L1 = (cut1 == 0) ? MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == N1) ? MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == N2) ? MAX_VALUE : nums2[cut2];
            if (L1 > R2) {
                cutR = cut1 - 1;
            } else if (L2 > R1) {
                cutL = cut1 + 1;
            } else {// Otherwise, that's the right cut.
                // 偶数个数的时候
                if (size % 2 == 0) {
                    L1 = (L1 > L2 ? L1 : L2);
                    R1 = (R1 < R2 ? R1 : R2);
                    return (L1 + R1) / 2;
                } else {
                    R1 = (R1 < R2 ? R1 : R2);
                    return R1;
                }
            }

        }
        return -1;
    }


}
