package com.chen.algorithm.study.test34;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * 自己写的，比较复杂
 *
 * @author :  chen weijie
 * @Date: 2019-11-10 17:15
 */
public class Solution {


    public int[] searchRange(int[] nums, int target) {


        int[] result = {Integer.MAX_VALUE, -Integer.MAX_VALUE};
        boolean modify = false;

        int start = 0, end = nums.length - 1;
        int mid;

        while (start <= end) {

            // mid=left+(right-left)/2 优化取中值
            mid = (start + end) / 2;

            if (nums[mid] == target) {
                modify = true;
                result[0] = Math.min(result[0], mid);
                result[1] = Math.max(result[1], mid);

                while (mid >= 0 && mid < nums.length && nums[mid] == target) {
                    mid--;
                    if (mid >= 0 && mid < nums.length && nums[mid] == target) {
                        result[0] = Math.min(result[0], mid);
                    } else {
                        break;
                    }
                }

                // 由于上面while循环后可能越界，所以必须重新找到原先的位置；
                mid = (start + end) / 2;

                while (mid >= 0 && mid < nums.length && nums[mid] == target) {
                    mid++;
                    if (mid >= 0 && mid < nums.length && nums[mid] == target) {
                        result[1] = Math.max(result[1], mid);
                    } else {
                        break;
                    }
                }
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }

        if (modify) {
            return result;
        } else {
            return new int[]{-1, -1};
        }

    }


    @Test
    public void testCase() {


        int[] n = {2, 2};

        int[] result = searchRange(n, 2);

        System.out.println(JSONObject.toJSONString(result));

    }


}
