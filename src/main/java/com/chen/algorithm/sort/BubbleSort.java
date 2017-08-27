package com.chen.algorithm.sort;

import org.junit.Test;

/**
 * 冒泡排序算法
 * Created by Chen Weijie on 2017/8/17.
 */
public class BubbleSort {


    @Test
    public void bubbleSort1() {

        int[] numbers = {1, 4, 7, 2, 10};

        int temp;

        int size = numbers.length;

        for (int i = 0; i < size - 1; i++) {

            for (int j = 0; j < size - 1 - i; j++) {

                if (numbers[j] > numbers[j + 1]) {

                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }

            }

        }

    }


}
