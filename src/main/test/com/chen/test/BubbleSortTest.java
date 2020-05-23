package com.chen.test;

/**
 * @author :  chen weijie
 * @Date: 2020-05-19 23:38
 */
public class BubbleSortTest {


    public static void solution(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        boolean flag = false;

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }


    public static void bubbleSort1(int[] numbers) {

        int size = numbers.length;

        boolean flag = false;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }

        }

    }

    public static void main(String[] args) {

        int[] array = {3, 0, 10, 4};
        bubbleSort1(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }


    }


}
