package com.chen.algorithm.sort;

/**
 * @author :  chen weijie
 * @Date: 2020-06-16 20:28
 */
public class Test {


    public static void main(String[] args) {
        int[] i1 = {4, 1, 2};
        int[] i2 = {1, 3, 4, 2};
        int[] res = nextGreaterElement(i1, i2);
        for (int i : res) {
            System.out.println(i);
        }

        System.out.println("Hello World!");
    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0) {
            return null;
        }


        for (int i = 0; i < nums1.length; i++) {
            int start = 0;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    start = j;
                    System.out.println("===" + start);
                    break;
                }
            }

            if (start == nums2.length - 1) {
                nums1[i] = -1;
                continue;
            }

            for (int j = start + 1; j < nums2.length; j++) {

                if (nums2[j] > nums1[i]) {
                    nums1[i] = nums2[j];
                    break;
                } else {
                    nums1[i] = -1;
                }
            }

        }

        return nums1;
    }


}
