package com.chen.api.util.array;

import java.util.Arrays;

/**
 * Created by Chen Weijie on 2017/7/16.
 */
public class Array {

    public static void main(String[] args) {

        int [] intArray ={1,9,2,5,3,6};
        //对数组从小到大排序
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));
        //二分查找 array中是否存在 3这个元素，如果存在，则返回该元素的下标
        int isExists =Arrays.binarySearch(intArray,3);
        System.out.println(isExists);


    }

}
