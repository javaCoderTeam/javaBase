package com.chen.algorithm.znn.tree.test437;

import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/solution/437lu-jing-zong-he-iii-di-gui-fang-shi-by-ming-zhi/
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * 示例：
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * 返回 3。和等于 8 的路径有:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * @Auther: zhunn
 * @Date: 2020/11/08 15:25
 * @Description: 路径总和 III
 * 以当前节点作为头结点的路径数量 + 以当前节点的左孩子作为头结点的路径数量 + 以当前节点的右孩子作为头结点啊路径数量
 */
public class Solution {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return countPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);   // 根结点开始或左右子树开始的所有路径之和
    }

    private int countPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum - root.val;
        int result = sum == 0 ? 1 : 0;
        return result + countPath(root.left, sum) + countPath(root.right, sum);
    }

    private int find(TreeNode root, int sum) {
        return (root.val == sum ? 1 : 0) +
                (root.left == null ? 0 : find(root.left, sum - root.val)) +
                (root.right == null ? 0 : find(root.right, sum - root.val));
    }

    private int paths(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res += 1;
        }
        res += paths(root.left, sum - root.val);
        res += paths(root.right, sum - root.val);
        return res;
    }

    @Test
    public void test() {
        TreeNode left = new TreeNode(1, new TreeNode(3), null);
        TreeNode right = new TreeNode(7, new TreeNode(15), new TreeNode(20));
        TreeNode root = new TreeNode(3, left, right);

        int res = pathSum(root, 7);
        System.out.println(res);
    }
}
