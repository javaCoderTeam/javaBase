package com.chen.algorithm.sort.study;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://blog.csdn.net/jianyuerensheng/article/details/51262984
 *
 * @author :  chen weijie
 * @Date: 2020-07-27 16:19
 */
public class MergeSortAll {


    public void merge(int[] a, int low, int high, int mid) {

        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {

            if (a[i] < a[j]) {
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
            a[l + low] = temp[l];
        }

    }

    public void mergeSort(int[] a, int low, int high) {

        int mid = (high + low) / 2;
        if (high > low) {
            // 左边
            mergeSort(a, low, mid);
            // 右边
            mergeSort(a, mid + 1, high);
            merge(a, low, high, mid);
            System.out.println("===" + Arrays.toString(a));
        }

    }

    @Test
    public void testCase() {

        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));


    }


}
