package com.chen.algorithm.sort.standrd;

/**
 *
 *
 // 归并排序算法, A是数组，n表示数组大小
 merge_sort(A, n) {
 merge_sort_c(A, 0, n-1)
 }

 // 递归调用函数
 merge_sort_c(A, p, r) {
 // 递归终止条件
 if p >= r  then return

 // 取p到r之间的中间位置q
 q = (p+r) / 2
 // 分治递归
 merge_sort_c(A, p, q)
 merge_sort_c(A, q+1, r)
 // 将A[p...q]和A[q+1...r]合并为A[p...r]
 merge(A[p...r], A[p...q], A[q+1...r])
 }
 * 归并排序
 * <p>
 * 　如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了。
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
