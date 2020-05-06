package com.chen.algorithm.dynamicprogramming;

/**
 * 动态规划实现背包问题
 * 我们有一个背包，背包总的承载重量是Wkg。现在我们有n个物品，每个物品的重量不等，并且不可分割。我们现在期望选择几件物品，
 * 装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 *
 * @author :  chen weijie
 * @Date: 2020-05-01 18:41
 */
public class ZeroOndBag3 {


    /**
     * 我们把整个求解过程分为n个阶段，每个阶段会决策一个物品是否放到背包中。每个物品决策（放入或者不放入背包）完之后，背包中的物品的重量会有多种情况，也就是说，会达到多种不同的状态，对应到递归树中，就是有很多不同的节点。
     *
     * 我们把每一层重复的状态（节点）合并，只记录不同的状态，然后基于上一层的状态集合，来推导下一层的状态集合。我们可以通过合并每一层重复的状态，这样就保证每一层不同状态的个数都不会超过w个（w表示背包的承载重量），也就是例子中的9。于是，我们就成功避免了每层状态个数的指数级增长。
     *
     * 我们用一个二维数组states[n][w+1]，来记录每层可以达到的不同状态。
     *
     * 第0个（下标从0开始编号）物品的重量是2，要么装入背包，要么不装入背包，决策完之后，会对应背包的两种状态，背包中物品的总重量是0或者2。我们用states[0][0]=true和states[0][2]=true来表示这两种状态。
     *
     * 第1个物品的重量也是2，基于之前的背包状态，在这个物品决策完之后，不同的状态有3个，背包中物品总重量分别是0(0+0)，2(0+2 or 2+0)，4(2+2)。我们用states[1][0]=true，states[1][2]=true，states[1][4]=true来表示这三种状态。
     *
     * 以此类推，直到考察完所有的物品后，整个states状态数组就都计算好了。我把整个计算的过程画了出来，你可以看看。图中0表示false，1表示true。我们只需要在最后一层，找一个值为true的最接近w（这里是9）的值，就是背包中物品总重量的最大值。
     * @param weight
     * @param n
     * @param w
     * @return
     */

    //    weight:物品重量（2、2、4、6、3），n:物品个数（0-5），w:背包可承载重量（0-9）
    public int knapsack(int[] weight, int n, int w) {

        boolean[][] states = new boolean[n][w + 1]; // 默认值false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        states[0][weight[0]] = true;
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {// 不把第i个物品放入背包
                if (states[i - 1][j] == true) {
                    states[i][j] = states[i - 1][j];
                }
            }
            for (int j = 0; j <= w - weight[i]; ++j) {//把第i个物品放入背包
                if (states[i - 1][j] == true) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n - 1][i] == true) {
                return i;
            }
        }
        return 0;
    }


}
