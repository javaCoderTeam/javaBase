package com.chen.algorithm.backtrack;

/**
 * 最短路径问题
 *
 * @author :  chen weijie
 * @Date: 2020-05-01 22:25
 */
public class Mindist {


    // 全局变量或者成员变量
    private int minDist = Integer.MAX_VALUE;

    // 调用方式：minDistBacktracing(0, 0, 0, w, n);
    public void minDistBT(int i, int j, int dist, int[][] w, int n) {
        // 到达了n-1, n-1这个位置了，这里看着有点奇怪哈，你自己举个例子看下
        if (i == n && j == n) {
            if (dist < minDist) {
                minDist = dist;
            }
            return;
        }
        // 往下走，更新i=i+1, j=j
        if (i < n) {
            minDistBT(i + 1, j, dist + w[i][j], w, n);
        }
        // 往右走，更新i=i, j=j+1
        if (j < n) {
            minDistBT(i, j + 1, dist + w[i][j], w, n);
        }
    }


}
