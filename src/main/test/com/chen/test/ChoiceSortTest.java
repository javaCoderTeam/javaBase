package com.chen.test;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-04-26 23:24
 */
public class ChoiceSortTest {


    @Test
    public void solution() {

        int[] array = {4, 6, 1, 2, 5, 10, 0, 11};


        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
            //第 i轮排序的结果为
            System.out.print("第" + (i + 1) + "轮排序后的结果为:");
            display(array);
        }
    }

    //遍历显示数组
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }



}
