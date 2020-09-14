package com.chen.algorithm.jianzhi.test66;

import org.junit.Test;

import java.util.Arrays;

/**
 * 整体思路，结果集中任何一个元素 = 其左边所有元素的乘积 * 其右边所有元素的乘积。
 * 一轮循环构建左边的乘积并保存在结果集中，
 * 二轮循环 构建右边乘积的过程，乘以左边的乘积，并将最终结果保存
 *
 * @author :  chen weijie
 * @Date: 2020-09-12 19:31
 */
public class Solution {


    public int[] constructArr(int[] a) {

        if (a == null || a.length == 0) {
            return new int[0];
        }

        int[] b = new int[a.length];
        b[0] = 1;
        int temp = 1;

        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }


        for (int i = a.length - 2; i >= 0; i--) {
            temp = a[i + 1] * temp;
            b[i] = temp * b[i];
        }

        return b;
    }


    @Test
    public void testCase() {
        int[] a = {1, 2, 3, 4, 5};
        int[] res = constructArr(a);

        System.out.println(Arrays.toString(res));
    }


}
