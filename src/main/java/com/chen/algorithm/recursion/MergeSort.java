package com.chen.algorithm.recursion;

/**
 * 归并排序
 * <p>
 * 　归并算法的中心是归并两个已经有序的数组。归并两个有序数组A和B，就生成了第三个有序数组C。数组C包含数组A和B的所有数据项。
 *
 * @author :  chen weijie
 * @Date: 2019-03-25 11:31 PM
 */
public class MergeSort {


    public static int[] sort(int[] a, int[] b) {


        int aNum = 0, bNum = 0, cNum = 0;

        int[] c = new int[a.length + b.length];

        while (aNum < a.length && bNum < b.length) {
            //将更小的复制给c数组
            if (a[aNum] > b[bNum]) {
                c[cNum++] = b[bNum++];
            } else {
                c[cNum++] = a[aNum++];
            }

            //如果a数组全部赋值到c数组了，但是b数组还有元素，则将b数组剩余元素按顺序全部复制到c数组
            while (aNum == a.length && bNum < b.length) {
                c[cNum++] = b[bNum++];
            }
            //如果b数组全部赋值到c数组了，但是a数组还有元素，则将a数组剩余元素按顺序全部复制到c数组
            while (bNum == b.length && aNum < a.length) {
                c[cNum++] = a[aNum++];
            }
        }
        return c;
    }


    public static void main(String[] args) {

        int[] a = {2, 5, 7, 8, 9, 10};
        int[] b = {1, 2, 3, 5, 6, 10, 29};


        int[] c = sort(a, b);

        for (int i = 0; i < c.length - 1; i++) {
            System.out.println(c[i]);
        }
        System.out.println();


    }


}
