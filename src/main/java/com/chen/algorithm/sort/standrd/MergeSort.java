package com.chen.algorithm.sort.standrd;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author :  chen weijie
 * @Date: 2020-07-27 17:07
 */
public class MergeSort {


    public void merge(int[] a, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;
        int k = 0;

        int[] temp = new int[high - low + 1];

        while (i <= mid && j <= high) {

            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= high) {
            temp[k++] = a[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            a[low + l] = temp[l];
        }
    }


    public void sort(int[] a, int low, int high) {

        int mid = (high - low) / 2 + low;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testCase() {
        int[] a = {4, 1, 3, 10, 13, 232, -1};
        sort(a, 0, a.length - 1);
        System.out.println("result=" + Arrays.toString(a));
    }


}
