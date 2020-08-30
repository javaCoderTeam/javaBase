package com.chen.algorithm.study.test144;


import java.util.ArrayList;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2020-05-11 23:21
 */
public class Solution1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return res;
    }

}
