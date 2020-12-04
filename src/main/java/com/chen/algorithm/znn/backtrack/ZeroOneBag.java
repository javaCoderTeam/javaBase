package com.chen.algorithm.znn.backtrack;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
 * 作为「0-1 背包问题」，它的特点是：「每个数只能用一次」。解决的基本思路是：物品一个一个选，容量也一点一点增加去考虑，这一点是「动态规划」的思想，特别重要。
 * 在实际生活中，我们也是这样做的，一个一个地尝试把候选物品放入「背包」，通过比较得出一个物品要不要拿走。
 *
 * 具体做法是：画一个 len 行，target + 1 列的表格。这里 len 是物品的个数，target 是背包的容量。len 行表示一个一个物品考虑，target + 1多出来的那 1 列，表示背包容量从 0 开始考虑。很多时候，我们需要考虑这个容量为 0 的数值。
 *
 * 我们有一个背包，背包总的承载重量是Wkg。现在我们有n个物品，每个物品的重量不等，并且不可分割。我们现在期望选择几件物品，
 * 装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 *
 * @Auther: zhunn
 * @Date: 2020/11/3 14:53
 * @Description: 0-1背包问题:1-回溯；2-动态规划
 */
public class ZeroOneBag {

    private int maxW = Integer.MAX_VALUE;
    private int[] items = {2, 2, 4, 6, 3};  // 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

    /**
     * 1-回溯
     * // 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
     * // f(0, 0, a, 10, 100)
     * <p>
     * 我们可以把物品依次排列，整个问题就分解为了 n 个阶段，每个阶段对应一个物品怎么选择。
     * 先对第一个物品进行处理，选择装进去或者不装进去，然后再递归地处理剩下的物品。
     *
     * @param i  表示考察到哪个物品了
     * @param cw 表示当前已经装进去的物品的重量和
     *           items 表示每个物品的重量
     *           n 表示物品个数
     *           w 背包重量
     */
    public void bag1(int i, int cw) {
        // cw==w表示装满了;i==n表示已经考察完所有的物品
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        bag1(i + 1, cw);
        // 已经超过可以背包承受的重量的时候，就不要再装了
        if (cw + items[i] <= w) {
            bag1(i + 1, cw + items[i]);
        }
    }

    private boolean[][] memo = new boolean[5][10];

    public void bag2(int i, int cw) {
        if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        if (memo[i][cw]) {
            return; // 重复状态
        }
        memo[i][cw] = true; // 记录(i, cw)这个状态
        bag2(i + 1, cw); // 选择不装第i个物品
        if (cw + items[i] <= w) {
            bag2(i + 1, cw + items[i]); // 选择装第i个物品
        }
    }

    /**
     * 2-动态规划
     * 我们把整个求解过程分为n个阶段，每个阶段会决策一个物品是否放到背包中。每个物品决策（放入或者不放入背包）完之后，背包中的物品的重量会有多种情况，也就是说，会达到多种不同的状态，对应到递归树中，就是有很多不同的节点。
     * 我们把每一层重复的状态（节点）合并，只记录不同的状态，然后基于上一层的状态集合，来推导下一层的状态集合。我们可以通过合并每一层重复的状态，这样就保证每一层不同状态的个数都不会超过w个（w表示背包的承载重量），也就是例子中的9。于是，我们就成功避免了每层状态个数的指数级增长。
     * 我们用一个二维数组states[n][w+1]，来记录每层可以达到的不同状态。
     * 第0个（下标从0开始编号）物品的重量是2，要么装入背包，要么不装入背包，决策完之后，会对应背包的两种状态，背包中物品的总重量是0或者2。我们用states[0][0]=true和states[0][2]=true来表示这两种状态。
     * 第1个物品的重量也是2，基于之前的背包状态，在这个物品决策完之后，不同的状态有3个，背包中物品总重量分别是0(0+0)，2(0+2 or 2+0)，4(2+2)。我们用states[1][0]=true，states[1][2]=true，states[1][4]=true来表示这三种状态。
     * 以此类推，直到考察完所有的物品后，整个states状态数组就都计算好了。我把整个计算的过程画了出来，你可以看看。图中0表示false，1表示true。我们只需要在最后一层，找一个值为true的最接近w（这里是9）的值，就是背包中物品总重量的最大值。
     *
     * @param weight weight:物品重量（2、2、4、6、3）
     * @param n      n:物品个数（0-5）
     * @param w      w:背包可承载重量（0-9）
     * @return
     * 状态定义：第一维n表示放了几个物品，第二维w表示放或放入物品后，背包里的总重量
     * 状态转移方程：
     * 思路：物品一个一个尝试，容量一点一点尝试，每个物品分类讨论的标准是：选与不选。
     */
    public int knapsack(int[] weight, int n, int w) {
        // 状态定义：第一维表示放了几个物品，第二维表示放或放入物品后，背包里的总重量
        boolean[][] states = new boolean[n][w + 1]; //默认值false
        states[0][0] = true; //初始化,第一行的数据要特殊处理，可以利用哨兵优化
        states[0][weight[0]] = true;

        for (int i = 1; i < n; i++) { // 动态规划状态转移
            for (int j = 0; j <= w; j++) { // 不把第i个物品放入背包
                if (states[i - 1][j]) {
                    states[i][j] = states[i - 1][j];
                }
            }
            for (int j = 0; j + weight[i] <= w; j++) { //把第i个物品放入背包
                if (states[i - 1][j]) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; i--) { // 输出结果
            if (states[n - 1][i]) {
                return i;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        int cw = knapsack(items, n, w);
        System.out.println(cw);
    }
}
