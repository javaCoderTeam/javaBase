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
public class ZeroOneBag {


    //存储背包中物品总重量的最大值
    public int maxW = Integer.MIN_VALUE;


    /**
     * // cw表示当前已经装进去的物品的重量和；i表示考察到哪个物品了；
     * // w背包重量；items表示每个物品的重量；n表示物品个数
     * // 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
     * // f(0, 0, a, 10, 100)
     *
     * 我们可以把物品依次排列，整个问题就分解为了 n 个阶段，每个阶段对应一个物品怎么选择。
     * 先对第一个物品进行处理，选择装进去或者不装进去，然后再递归地处理剩下的物品。
     *
     * @param i
     * @param cw
     * @param items
     * @param n
     * @param w
     */
    public void solution(int i, int cw, int[] items, int n, int w) {
        // cw==w表示装满了;i==n表示已经考察完所有的物品
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        solution(i + 1, cw, items, n, w);
        // 已经超过可以背包承受的重量的时候，就不要再装了
        if (cw + items[i] <= w) {
            solution(i + 1, cw + items[i], items, n, w);
        }
    }



}
