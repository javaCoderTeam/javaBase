package com.chen.algorithm.znn.dynamic.test337;

import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/solution/shu-xing-dp-ru-men-wen-ti-by-liweiwei1419/
 *
 * @Auther: zhunn
 * @Date: 2020/11/6 18:35
 * @Description: 打家劫舍 III：1-树的后序遍历；
 */
public class Solution {

    public int rob(TreeNode root) {
        int[] res = dfs(root);  // 树的后序遍历
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(root.left);    // 分类讨论的标准是：当前结点偷或者不偷
        int[] right = dfs(root.right);  // 由于需要后序遍历，所以先计算左右子结点，然后计算当前结点的状态值


        int[] res = new int[2];     // dp[0]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点不偷; dp[1]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点偷
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

    @Test
    public void test() {
        TreeNode left = new TreeNode(2, null, new TreeNode(3));
        TreeNode right = new TreeNode(3, null, new TreeNode(1));
        TreeNode root = new TreeNode(3, left, right);
        System.out.println(rob(root));
    }
}
