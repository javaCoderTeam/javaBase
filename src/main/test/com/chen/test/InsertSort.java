package com.chen.test;

/**
 * @author :  chen weijie
 * @Date: 2020-05-25 10:23
 */
public class InsertSort {




    public static void testSort(int [] array){

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int left = i - 1;
            while (left >= 0 && temp < array[left]) {
                array[left + 1] = array[left];
                left--;
            }
            array[left + 1] = temp;
        }

    }

    //遍历显示数组
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {6,8,1,2,4};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
        testSort(array);
        System.out.println("-----------------------");
        System.out.println("经过插入排序后的数组顺序为：");
        display(array);
    }


}
