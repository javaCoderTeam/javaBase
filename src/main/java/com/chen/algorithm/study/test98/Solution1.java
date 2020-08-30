package com.chen.algorithm.study.test98;

import java.util.Stack;

/**
 * @author :  chen weijie
 * @Date: 2020-08-30 20:54
 */
public class Solution1 {


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

        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

//        int preVal = Integer.MIN_VALUE;
          double preVal = -Double.MAX_VALUE;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            int currVal = curr.val;
            if (preVal >= currVal) {
                return false;
            }
            preVal = currVal;
            curr = curr.right;
        }
        return true;
    }





}
