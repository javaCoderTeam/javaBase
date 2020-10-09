package com.chen.algorithm.study.test704;

/**
 * @Auther: zhunn
 * @Date: 2020/10/9 15:31
 * @Description: 二分查找 https://blog.csdn.net/Lngxling/article/details/78217619
 */
public class Solution {

    /**
     * 适用于升序数组，可做相应调整适用降序数组
     */
    public static int bsearch(int[] array, int target) {
        if (array == null || array.length == 0
            /*|| target < array[0] || target > array[array.length - 1]*/) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        //这里必须是 >=,切记遗漏 =
        while (right >= left) {
            // 当start=Integer.MAX_VALUE时，给它加个1都会溢出。安全的写法是：mid = start + (end-start)/2,但是会造成死循环，弃用
            //int mid = min + (max - min) >> 1;
            int mid = (left + right) >> 1;
            if (target == array[mid]) {
                return mid;
            }
            if (target < array[mid]) {
                right = mid - 1;
            }
            if (target > array[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个与target相等的元素
     * 当key=array[mid]时， 往左边一个一个逼近，right = mid -1; 返回left
     */
    public static int bsearch1(int[] array, int target) {
        if (array == null || array.length == 0
            /*|| target < array[0] || target > array[array.length - 1]*/) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (right >= left) {
            int mid = (left + right) >> 1;
            if (array[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left < array.length && array[left] == target) {
            return left;
        }
        return -1;

    }

    /**
     * 查找最后一个与target相等的元素
     * 当key=array[mid]时， 往右边一个一个逼近，left = mid + 1; 返回right
     *
     * @return
     */
    public static int bsearch2(int[] array, int target) {
        if (array == null || array.length == 0 /*|| target < array[0] || target > array[array.length - 1]*/) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (right >= left) {
            int mid = (left + right) >> 1;
            if (array[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right >= 0 && array[right] == target) {
            return right;
        }
        return -1;
    }

    // 二分查找变种说明
    //public void test(int[] array, int target){
    //
    //    int left = 0;
    //    int right = array.length - 1;
    //    // 这里必须是 <=
    //    while (left <= right) {
    //        int mid = (left + right) / 2;
    //        if (array[mid] ? key) {
    //            //... right = mid - 1;
    //        }
    //        else {
    //            // ... left = mid + 1;
    //        }
    //    }
    //    return xxx;
    //}


    /**
     * 查找第一个等于或者大于key的元素
     */
    public static int bsearch3(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (right >= left) {
            int mid = (left + right) >> 1;
            if (array[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 查找第一个大于key的元素
     */
    public static int bsearch4(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (right >= left) {
            int mid = (left + right) >> 1;
            if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 查找最后一个等于或者小于key的元素
     */
    public static int bsearch5(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (right >= left) {
            int mid = (left + right) >> 1;
            if (array[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    /**
     * 查找最后一个小于key的元素
     */
    public static int bsearch6(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (right >= left) {
            int mid = (left + right) >> 1;
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 3, 6, 6, 6, 7, 9, 17, 17};
        int index = bsearch6(array, 0);
        System.out.println(index);
    }
}
