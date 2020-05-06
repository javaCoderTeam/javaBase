package com.chen.algorithm.backtrack;

/**
 * 0-1 背包问题
 * <p>
 * <p>
 * 我们有一个背包，背包总的承载重量是Wkg。现在我们有n个物品，每个物品的重量不等，并且不可分割。我们现在期望选择几件物品，
 * 装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 *
 * @author :  chen weijie
 * @Date: 2020-05-01 18:10
 */
public class ZeroOneBag2 {


    private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量
    private boolean[][] mem = new boolean[5][10]; // 备忘录，默认值false

    public void f(int i, int cw) { // 调用f(0, 0)
        if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        if (mem[i][cw]) {
            return; // 重复状态
        }
        mem[i][cw] = true; // 记录(i, cw)这个状态
        f(i + 1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]); // 选择装第i个物品
        }
    }


}
