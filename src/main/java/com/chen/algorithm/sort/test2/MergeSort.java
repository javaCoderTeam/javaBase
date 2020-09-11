package com.chen.algorithm.sort.test2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author :  chen weijie
 * @Date: 2020-08-03 10:52
 */
public class MergeSort {


    public void merge(int[] a,int low, int high, int mid){

        int i = low, j = mid + 1, k = 0;
        int [] temp = new int[high - low + 1];

        while (i <= mid || j <= high) {

            if (i <= mid && j <= high) {
                if (a[i] < a[j]) {
                    temp[k++] = a[i++];
                } else {
                    temp[k++] = a[j++];
                }
            } else if (i <= mid) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        System.arraycopy(temp, 0, a, low, temp.length);
    }


    public void mergeSort(int low, int high, int[] a) {

        if (low < high) {
            int mid = (high - low) / 2 + low;
            mergeSort(low, mid, a);
            mergeSort(mid + 1, high, a);
            merge(a, low, high, mid);
        }
    }

    public void merge2(int left, int right, int mid, int[] nums) {

        int i = left, j = mid + 1, k = 0;
        int[] temp = new int[right - left + 1];

        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        System.arraycopy(temp, 0, nums, left, temp.length);
    }


    public void mergeSort2(int left, int right, int[] nums) {

        if (right > left) {
            int mid = (left + right) / 2;
            mergeSort2(left, mid, nums);
            mergeSort2(mid + 1, right, nums);
            merge2(left, right, mid, nums);
        }
    }

    @Test
    public void testCase() {
        int[] a = {4, 1, 3, 10, 13, 232, -1};
        mergeSort2(0, a.length - 1, a);
        System.out.println("result=" + Arrays.toString(a));
    }

    @Test
    public void testCase2() {
        int[] a = {1, 3, 4};
        int[] b = {2, 5, 9, 10, 23,};
        int[] res = mergeArray(a, b);
        System.out.println("result=" + Arrays.toString(res));
    }


    public static int[] mergeArray(int[] aArray, int[] bArray) {

        int[] res = new int[aArray.length + bArray.length];
        int pA = 0, pB = 0;
        int pC = 0;

        while (pA < aArray.length || pB < bArray.length) {

            if (pA < aArray.length && pB < bArray.length) {
                if (aArray[pA] < bArray[pB]) {
                    res[pC++] = aArray[pA++];
                } else {
                    res[pC++] = bArray[pB++];
                }

            } else if (pA < aArray.length) {
                res[pC++] = aArray[pA++];
            } else if (pB < bArray.length) {
                res[pC++] = bArray[pB++];
            }
        }

        return res;
    }


}
