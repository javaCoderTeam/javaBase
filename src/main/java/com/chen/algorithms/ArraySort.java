package com.chen.algorithms;

/**
 * 两个有序数组合并为一个有序数组
 * http://www.cnblogs.com/A_ming/archive/2010/04/15/1712313.html
 *
 * @Author chenweijie
 * @Date 2017/10/16 2:18
 */
public class ArraySort {

    //两个有序数组的合并函数
    public static int[] mergeList(int[] a, int[] b) {

        int result[];

        if (checkSort(a) && checkSort(b)) {

            result = new int[a.length + b.length];

            //i:用于标示a数组    j：用来标示b数组  k：用来标示传入的数组
            int i = 0, j = 0, k = 0;
            while (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    result[k++] = a[i++];
                } else {
                    result[k++] = b[j++];
                }

            }

            // 后面连个while循环是用来保证两个数组比较完之后剩下的一个数组里的元素能顺利传入

            while (i < a.length) {
                result[k++] = a[i++];
            }

            while (j < b.length) {
                result[k++] = b[j++];
            }

            return result;


        } else {
            System.out.println("非有序数组。。。");
            return null;
        }

    }


    //检查数组是否是顺序存储的
    public static boolean checkSort(int[] n) {

        //这个标志位是一种优化程序的方法，可以看看我写的冒泡排序优化就会明白了
        boolean change = true;

        for (int i = 0; i < n.length - 1 && change; i++) {

            for (int j = 0; j < j - 1 - i; j++) {
                if (n[j] > n[j + 1]) {
                    return false;
                } else {
                    change = false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {

        int a[] = {1, 2, 2, 3, 5, 6, 7, 7};
        int b[] = {1, 2, 4, 5, 8, 8, 9, 10, 11, 12, 12, 13, 14};

        int c[] = mergeList(a, b);
        if (c != null) {
            for (int t : c) {
                System.out.println(t);
            }
        } else {
            System.out.println("");
        }

    }


}
