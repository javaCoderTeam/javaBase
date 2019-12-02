package com.chen.algorithm.study.test543;

/**
 *
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/javade-di-gui-jie-fa-by-lyl0724-2/
 *
 * @author :  chen weijie
 * @Date: 2019-11-04 23:58
 */
public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


//    一个节点的最大直径 = 它左树的高度 +  它右树的高度

    private int max;


    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }


    private int depth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        //max记录当前的最大直径
        max = Math.max(leftDepth + rightDepth, max);
        //由于我计算的直径是左树高度+右树高度，所以这里返回当前树的高度，以供使用
        return Math.max(leftDepth, rightDepth) + 1;
    }



}
