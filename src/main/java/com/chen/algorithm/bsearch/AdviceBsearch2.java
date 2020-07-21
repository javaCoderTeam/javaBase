package com.chen.algorithm.bsearch;

import org.junit.Test;

/**
 * https://blog.csdn.net/bat67/article/details/72049104
 *
 * @author :  chen weijie
 * @Date: 2020-07-03 16:45
 */
public class AdviceBsearch2 {


    /**
     * 获取第一个等于target的目标，当key=array[mid]时， 往左边一个一个逼近，right = mid -1; 返回left
     *
     * @param array
     * @param target
     * @return
     */
    public int bSearch(int[] array, int target) {

        int start = 0, end = array.length - 1;
        while (end >= start) {
            int mid = start + (end - start) / 2;

            if (array[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (start < array.length - 1 && array[start] == target) {
            return start;
        }
        return -1;
    }


    /**
     * 获取最后一个等于target的目标，当key=array[mid]时， 往右边一个一个逼近，left = mid + 1; 返回right
     *
     * @param array
     * @param target
     * @return
     */
    public int bSearch2(int[] array, int target) {

        int left = 0, right = array.length - 1;

        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (right >= 0 && array[right] == target) {
            return right;
        }
        return -1;
    }

    /**
     * 获取最后一个小于等于target的目标，当key=array[mid]时， 往右边一个一个逼近，left = mid + 1; 返回right
     *
     * @param array
     * @param target
     * @return
     */
    public int bSearch3(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    /**
     * 查找第一个等于或者大于target的目标，当key=array[mid]时， 往左边一个一个逼近，right = mid - 1; 返回left
     *
     * @param array
     * @param target
     * @return
     */
    public int bSearch4(int[] array, int target) {

        int left = 0, right = array.length - 1;

        while (right >= left) {

            int mid = left + (right - left) / 2;

            if (array[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        return left;
    }


    @Test
    public void test() {

        int[] n = {3, 4, 5, 7, 8, 9, 10};
        int res = bSearch4(n, 6);
        System.out.println(res);

    }


}
