package com.chen.algorithm.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/jiao-ti-shi-yong-zhan-jian-dan-shi-xian-ju-chi-xin/
 *
 * @author :  chen weijie
 * @Date: 2020-08-23 17:01
 */
public class test103 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Stack<TreeNode>  stack1 = new Stack<>();
        Stack<TreeNode>  stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty() ||!stack2.isEmpty()){

            List<Integer> list = new ArrayList<>();
            res.add(list);
            if (!stack1.isEmpty()){
                while (!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if (node.left !=null){
                        stack2.push(node.left);
                    }
                    if (node.right != null){
                        stack2.push(node.right);
                    }
                }
            }else {
                while (!stack2.isEmpty()){
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if (node.right !=null){
                        stack1.push(node.right);
                    }
                    if (node.left != null){
                        stack1.push(node.left);
                    }
                }
            }
        }
        return res;
    }

}
