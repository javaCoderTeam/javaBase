package com.chen.algorithm.sort.study;

/**
 * @author :  chen weijie
 * @Date: 2019-11-27 00:51
 */
public class BinInsertSort {


    public static int[] binInsertSort(int[] a) {

        int low, mid, high;
        int temp;
        for (int i = 1; i < a.length; i++) {
            temp = a[i];
            low = 0;
            high = i - 1;

            while (low <= high) {
                mid = (low + high) / 2;
                if (temp < a[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            //将a[low]--a[i-1]的数都想后移一位
            for (int j = i; j > low; j--) {
                a[j] = a[j - 1];
            }
            //最后将a[i]插入a[low]
            a[low] = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] array = {6, 8, 1, 2, 4};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        System.out.println("-----------------------");
        binInsertSort(array);
        System.out.println("-----------------------");
        System.out.println("经过插入排序后的数组顺序为：");
    }


}
