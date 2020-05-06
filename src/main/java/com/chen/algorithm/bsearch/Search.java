package com.chen.algorithm.bsearch;

/**
 * 不用递归的二分查找
 *
 * @author :  chen weijie
 * @Date: 2019-03-15 12:23 AM
 */
public class Search {


    /**
     * 找到目标值返回数组下标，找不到返回-1
     *
     * @param array
     * @param key
     * @return
     */
    public static int findTwoPoint(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int min = 0;
        int max = array.length - 1;

        while (max >= min) {

            int mid = (max + min) / 2;
            if (key == array[mid]) {
                return mid;
            }
            if (key > array[mid]) {
                min = mid + 1;
            }

            if (key < array[mid]) {
                max = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 递归二分查找
     *
     * @param low   低位
     * @param high  高位
     * @param array 有序数组
     * @param key   要查找的值
     * @return
     */
    public static int sort(int low, int high, int[] array, int key) {

        while (low < high) {
            int mid = (low + high) / 2;

            if (key == array[mid]) {

                return mid;
            }

            if (key > array[mid]) {
                low = mid + 1;
                sort(low, high, array, key);
            }

            if (key < array[mid]) {
                high = mid - 1;
                sort(low, high, array, key);
            }
        }
        return -1;
    }





}
