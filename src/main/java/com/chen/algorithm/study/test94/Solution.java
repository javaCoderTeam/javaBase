package com.chen.algorithm.study.test94;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2019-11-24 19:06
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

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {


        if (root == null) {
            return result;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);

        return result;
    }


}
