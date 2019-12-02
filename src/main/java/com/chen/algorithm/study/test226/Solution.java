package com.chen.algorithm.study.test226;

/**
 * @author :  chen weijie
 * @Date: 2019-11-03 17:33
 */
public class Solution {


    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        if (root.right == null && root.left == null) {
            return root;
        }


        if (root.left != null) {
            invertTree(root.left);
        }

        if (root.right != null) {
            invertTree(root.right);
        }

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }










}
