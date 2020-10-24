package com.chen.algorithm.znn.array.test56;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/solution/pai-xu-by-powcai/
 *
 * @author: zhunn
 * @Date: 2020-10-14 00:22
 * @Description: 合并区间
 */
public class Solution {


    /**
     * 先按首位置进行排序;
     * <p>
     * 接下来,如何判断两个区间是否重叠呢?比如 a = [1,4],b = [2,3]
     * 当 a[1] >= b[0] 说明两个区间有重叠.
     * 但是如何把这个区间找出来呢?
     * 左边位置一定是确定，就是 a[0]，而右边位置是 max(a[1], b[1])
     * 所以,我们就能找出整个区间为:[1,4]
     *
     * @param intervals
     * @return
     */

    public int[][] merge(int[][] intervals) {

        List<int[]> inner = Arrays.asList(intervals);
        List<int[]> newInner = new ArrayList<>(inner);
        newInner.sort((o1,o2)-> o1[0]-o2[0]);

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < newInner.size(); ) {
            int t = newInner.get(i)[1];
            int j = i + 1;
            while (j < newInner.size() && newInner.get(j)[0] <= t) {
                t = Math.max(t, newInner.get(j)[1]);
                j++;
            }
            res.add(new int[]{newInner.get(i)[0], t});
            i = j;
        }

        int[][] array = new int[res.size()][2];

        for (int i = 0; i < res.size(); i++) {
            array[i][0] = res.get(i)[0];
            array[i][1] = res.get(i)[1];
        }
        return array;
    }


    @Test
    public void testCase() {

        int[][] n = {{1, 3}, {2, 6}, {15, 18}, {8, 10}};
        System.out.println(JSONObject.toJSONString(merge(n)));
    }

}
