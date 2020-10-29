package com.chen.algorithm.znn.tree.test235;

import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

/**
 * @Auther: zhunn
 * @Date: 2020/10/29 15:02
 * @Description: 二叉搜索树的最近公共祖先
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }

    @Test
    public void test() {
        TreeNode left = new TreeNode(1);
        TreeNode  right = new TreeNode(7, new TreeNode(6), new TreeNode(20));
        TreeNode root = new TreeNode(3, left, right);

        TreeNode res = lowestCommonAncestor(root, left, right);
        System.out.println(res.val);
    }
}
