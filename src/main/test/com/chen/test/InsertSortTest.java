package com.chen.test;

import org.junit.Test;

/**
 * @author :  chen weijie
 * @Date: 2020-04-26 23:39
 */
public class InsertSortTest {


    @Test
    public void solution() {

        int[] array = {4, 1, 0, 10, 5};

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int leftIndex = i - 1;
            while (leftIndex >= 0 && temp < array[leftIndex]) {
                array[leftIndex + 1] = array[leftIndex];
                leftIndex--;
            }
            array[leftIndex + 1] = temp;
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
