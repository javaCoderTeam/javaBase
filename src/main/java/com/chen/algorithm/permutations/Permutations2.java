package com.chen.algorithm.permutations;

/**
 * User: chenweijie
 * Date: 10/18/17
 * Time: 10:44 PM
 * Description: 字符数组组成的所有字符串 (全排列)
 */
public class Permutations2 {


    /**
     * 无重复项
     * 标记数组当前位置，即n=0时，对arr[0]到arr[length-1]全排列；
     * n=1时，对arr[1]到arr[length-1]全排列...以此类推，length为数组长度
     */
    public static void solution(int[] arr, int n) {
        int length = arr.length;
        //当n定位到最后一个数时，即到递归出口
        if (n >= length - 1) {
            print(arr);
        } else {
            //将length-n个数分别放在第n个位置
            for (int i = n; i < length; i++) {
                //以交换位置的方式实现
                {
                    int temp = arr[n];
                    arr[n] = arr[i];
                    arr[i] = temp;
                }
                //对剩下的length-n-1个数全排列
                solution(arr, n + 1);
                //恢复原来的顺序，进行下一次交换
                {
                    int temp = arr[n];
                    arr[n] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }


    public void swap(int[] cs, int index1, int index2) {
        int temp = cs[index1];
        cs[index1] = cs[index2];
        cs[index2] = temp;
    }

    public static void print(int[] cs) {
        for (int i = 0; i < cs.length; i++) {
            System.out.print(cs[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        solution(arr, 0);
    }

}
