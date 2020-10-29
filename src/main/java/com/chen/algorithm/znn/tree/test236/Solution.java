package com.chen.algorithm.znn.tree.test236;

import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: zhunn
 * @Date: 2020/10/29 15:29
 * @Description: 二叉树的最近公共祖先：1-递归；2-存储父节点
 */
public class Solution {

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root;
    }

    /**
     * 2-存储父节点
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    @Test
    public void test() {
        TreeNode left = new TreeNode(7, new TreeNode(5), new TreeNode(9));
        TreeNode right = new TreeNode(2);
        TreeNode root = new TreeNode(8, left, right);

        TreeNode res = lowestCommonAncestor2(root, left, right);
        System.out.println(res.val);
    }

}
