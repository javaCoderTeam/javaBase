package com.chen.algorithm.study.test98;

/**
 * @author :  chen weijie
 * @Date: 2020-08-30 18:32
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


    /**
     * 要求根节点大于左子树的最大值，小于右子树的最小值
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }


    public boolean isValid(TreeNode root, Integer max, Integer min) {

        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }


}
