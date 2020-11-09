package com.chen.algorithm.znn.tree.test437;

import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

/**
 * @Auther: zhunn
 * @Date: 2020/11/08 15:25
 * @Description: 路径总和 III
 */
public class Solution {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return find(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int find(TreeNode root, int sum) {
        return (root.val == sum ? 1 : 0) +
                (root.left == null ? 0 : find(root.left, sum - root.val)) +
                (root.right == null ? 0 : find(root.right, sum - root.val));
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
