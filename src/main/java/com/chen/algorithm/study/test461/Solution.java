package com.chen.algorithm.study.test461;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/hamming-distance/solution/yi-huo-cao-zuo-by-zhang-heng-6/
 *
 * @author :  chen weijie
 * @Date: 2019-11-04 22:51
 */
public class Solution {


    public int hammingDistance(int x, int y) {

        int n = x ^ y;

        return Integer.bitCount(n);
    }


    @Test
    public void testCase() {

        System.out.println(hammingDistance(1, 4));
    }

}
