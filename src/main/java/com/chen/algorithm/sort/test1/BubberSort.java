package com.chen.algorithm.sort.test1;

/**
 * @author :  chen weijie
 * @Date: 2020-07-04 18:24
 */
public class BubberSort {


    public static void sort(int[] array) {

        if (array == null || array.length == 0) {
            return;
        }

        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }

                if (!flag) {
                    break;
                }
            }
            System.out.println("第" + i + "次排序完为:");
            display(array);
        }
    }

    /// 遍历显示数组
    public static void display(int[] array) {
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] array = {3, 0, 1, 90, 2, -1, 4};
        sort(array);
        System.out.println("最后的结果为：");
        display(array);
    }


}
