package com.chen.algorithm.study.test102;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2019-12-03 00:47
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


    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return null;
        }


        List<List<Integer>> result = new ArrayList<>();

        result.add(Arrays.asList(root.val));


        while (root.left!=null||root.right!=null){

            List<Integer> list = new ArrayList<>();
            



        }




        return null;
    }


}
