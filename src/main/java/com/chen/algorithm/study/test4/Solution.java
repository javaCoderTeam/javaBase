package com.chen.algorithm.study.test4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2019-09-03 23:10
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> resultList = new ArrayList<>();


        if (nums1 == null) {
            for (int value : nums2) {
                resultList.add(value);
            }
        } else if (nums2 == null) {
            for (int value : nums1) {
                resultList.add(value);
            }
        } else {




        }


        int n = resultList.size();


        double result = 0d;

        if (n % 2 == 0) {
            result = resultList.get(resultList.size() / 2) + (resultList.get((resultList.size() / 2) - 1)) / 2;
        } else {
            double index = resultList.size() / 2;
            result = resultList.get((int) Math.ceil(index));
        }
        return result;
    }


    @Test
    public void testCase() {

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        double d = findMedianSortedArrays(nums1, nums2);
        System.out.println(d);


    }


}
