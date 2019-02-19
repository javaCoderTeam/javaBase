package com.chen.algorithm.exercise;

/**
 * @author :  chen weijie
 * @Date: 2019-02-20 12:53 AM
 */


/**
 * 二维数组是有序的：从右上角来看，从左向右依次递减；向下数字递增；
 * <p>
 * 从右上角开始查找。
 * 当要查找的数字比右上角的数字大时，下移；
 * 当要查找的数字比右上角的数字小时，左移；
 * 如果出了边界，则说明二维数组中不存在该整数。
 */
public class Solution {


    public static boolean find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }

        int m = 0;
        int n = array[0].length - 1;
        int temp = array[m][n];
        while (temp != target) {
            if (m < array.length - 1 && n > 0) {
                if (target > temp) {
                    m++;
                } else if (target < temp) {
                    n--;
                }
                temp = array[m][n];
            } else {
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        int[][] array = {{4, 5, 6, 7, 8}, {21, 23, 25, 27, 29}, {33, 44, 55, 66, 77}};
        int target = 23;
        boolean flag = find(target, array);
        System.out.println("flag====" + flag);
    }
}
