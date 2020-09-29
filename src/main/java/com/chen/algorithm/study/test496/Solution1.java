package com.chen.algorithm.study.test496;

import java.util.*;

/**
 * @author :  chen weijie
 * @Date: 2020-09-27 01:31
 */
public class Solution1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            while (!stack.isEmpty() && stack.peek() <num ){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }

        int i = 0;
        for (int num: nums1){
            nums1[i++] = map.getOrDefault(num,-1);
        }

        return nums1;
    }
}
