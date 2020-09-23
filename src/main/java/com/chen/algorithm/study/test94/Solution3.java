package com.chen.algorithm.study.test94;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author :  chen weijie
 * @Date: 2019-11-24 19:06
 */
public class Solution3 {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while ( !stack.isEmpty() || curr !=null){
                while (curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                result.add(curr.val);
                curr = curr.right;
        }
        return result;
    }

    @Test
    public void testCase() {

        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root.right = root2;
        root2.left = root3;
        System.out.println(JSONObject.toJSONString(inorderTraversal(root)));

    }


}
