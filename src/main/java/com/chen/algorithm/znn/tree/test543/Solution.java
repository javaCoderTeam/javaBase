package com.chen.algorithm.znn.tree.test543;

import com.alibaba.fastjson.JSON;
import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

/**
 * @Auther: zhunn
 * @Date: 2020/10/29 14:26
 * @Description: 二叉树的直径: = 左子树的深度+右子树的深度
 * = 经过的左子树的节点数+右子树的节点数-1 = 左子树的深度+右子树的深度 + 1 - 1
 */
public class Solution {

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        ans = Math.max(ans, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    //public int diameterOfBinaryTree2(TreeNode root) {
    //    depth2(root);
    //    return ans - 1;
    //}
    //
    //private int depth2(TreeNode node) {
    //    if (node == null) {
    //        return 0; // 访问到空节点了，返回0
    //    }
    //    int L = depth(node.left); // 左儿子为根的子树的深度
    //    int R = depth(node.right); // 右儿子为根的子树的深度
    //    ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
    //    return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    //}

    @Test
    public void test() {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(7, new TreeNode(15), new TreeNode(20));
        TreeNode root = new TreeNode(3, left, right);

        int res = diameterOfBinaryTree(root);
        System.out.println(JSON.toJSON(res));
    }
}
