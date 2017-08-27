package com.chen.algorithm.bsearch;

import org.junit.Test;

/**
 * 存在数组中
 * 有序排列
 * 满足条件可以使用二分查找
 * Created by Chen Weijie on 2017/8/17.
 */
public class Bsearch {


    @Test
    public int bSearch(int[] array, int high, int low, int target) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (array[mid] > target) {
            high = mid - 1;
            return bSearch(array, low, high, target);
        }

        if (array[mid] < target) {
            low = mid + 1;
            return bSearch(array, low, high, target);
        }

        return mid;
    }

    @Test
    public int bSearch(int low, int high, int[] nums, int target) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (target > nums[mid]) {
            low = mid + 1;
            return bSearch(low, high, nums, target);
        } else if (target < nums[mid]) {
            high = mid + 1;
            return bSearch(low, high, nums, target);
        } else {
            return mid;
        }

    }









}
