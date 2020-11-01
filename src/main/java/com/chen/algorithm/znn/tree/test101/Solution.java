package com.chen.algorithm.znn.tree.test101;

import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: zhunn
 * @Date: 2020/10/29 11:03
 * @Description: 对称二叉树：1-递归，2-迭代
 */
public class Solution {

    /**
     * 1-递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.val == root2.val) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    /**
     * 2-迭代
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(u);
        queue.add(v);
        while (!queue.isEmpty()) {
            u = queue.poll();
            v = queue.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            queue.add(u.left);
            queue.add(v.right);

            queue.add(u.right);
            queue.add(v.left);
        }
        return true;
    }

    @Test
    public void test() {
        TreeNode left3 = new TreeNode(3);
        TreeNode right4 = new TreeNode(4);
        TreeNode left3_3 = new TreeNode(3);
        TreeNode right4_4 = new TreeNode(4);
        TreeNode left2 = new TreeNode(2, left3, right4);
        TreeNode right2 = new TreeNode(2, right4_4, left3_3);
        TreeNode root = new TreeNode(1, left2, right2);

        System.out.println(isSymmetric2(root));

    }
}