package com.chen.algorithm.znn.dynamic.test337;

import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/solution/shu-xing-dp-ru-men-wen-ti-by-liweiwei1419/
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * 示例 1:
 * 输入: [3,2,3,null,3,null,1]
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * 输入: [3,4,5,1,3,null,1]
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
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
