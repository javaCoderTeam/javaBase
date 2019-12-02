package com.chen.algorithm.study.test33;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-bai-liao-9983de-javayong-hu-by-reedfan/
 *
 * @author :  chen weijie
 * @Date: 2019-11-10 16:32
 */
public class Solution {


    public int search(int[] nums, int target) {


        if (nums == null || nums.length == 0) {
            return -1;
        }


        int start = 0, end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (end + start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {

                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    @Test
    public void testCase(){

        int [] n1 = {2 ,3, 4, 5, 6, 7, 1};

        int [] n2 = {6 ,7, 1, 2, 3, 4, 5};


//        System.out.println(search(n1,4));

        System.out.println(search(n2,4));




    }




}
