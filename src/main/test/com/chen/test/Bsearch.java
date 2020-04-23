package com.chen.test;

/**
 * @author :  chen weijie
 * @Date: 2020-04-22 07:18
 */
public class Bsearch {


    public int search(int[] array, int target, int high, int low) {

        if (array.length == 0) {
            return -1;
        }

        if (low > high) {
            return -1;
        }

        int mid = high - (high - low) >>> 1;
        if (target > array[mid]) {
            low = mid + 1;
            search(array, target, high, low);
        } else if (target < array[mid]) {
            high = mid - 1;
            search(array, target, high, low);
        } else {
            return mid;
        }

        return -1;
    }


    public int search2(int[] array, int target) {

        int high = array.length - 1;
        int low = 0;
        int mid = high - (high - low) >>> 1;

        while (high > low) {
            if (target > array[mid]) {
                low = mid + 1;
            } else if (target < array[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }




}
