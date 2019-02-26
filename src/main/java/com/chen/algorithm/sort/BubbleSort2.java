package com.chen.algorithm.sort;

/**
 * @author :  chen weijie
 * @Date: 2019-02-26 11:29 PM
 */
public class BubbleSort2 {


    public static int[] sort(int[] intArray) {


        if (intArray.length == 0) {
            return new int[0];
        }
        //这里for循环表示总共需要比较多少轮
        for (int i = 0; i < intArray.length; i++) {
            //这里for循环表示每轮比较参与的元素下标
            for (int j = 1; j < intArray.length; j++) {
                if (intArray[j - 1] > intArray[j]) {
                    int temp;
                    temp = intArray[j - 1];
                    intArray[j - 1] = intArray[j];
                    intArray[j] = temp;
                }

            }
            System.out.println("第" + i + "次排序完为:");
            display(intArray);
        }
        return intArray;
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
