package com.chen.algorithm.znn.tree.test543;

import com.alibaba.fastjson.JSON;
import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
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
