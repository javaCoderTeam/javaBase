package com.chen.algorithm.study.test496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author :  chen weijie
 * @Date: 2020-09-27 01:31
 */
public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> nextGreatMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];

            while (!stack.isEmpty() && stack.peek() <= num) {
                nextGreatMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            nextGreatMap.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreatMap.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
