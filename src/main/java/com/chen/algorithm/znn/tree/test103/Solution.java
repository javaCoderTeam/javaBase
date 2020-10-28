package com.chen.algorithm.znn.tree.test103;

import com.alibaba.fastjson.JSON;
import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/jiao-ti-shi-yong-zhan-jian-dan-shi-xian-ju-chi-xin/
 *
 * @Auther: zhunn
 * @Date: 2020/10/28 15:03
 * @Description: 二叉树的锯齿形层次遍历：交替使用栈
 */
public class Solution {

    /**
     * 交替使用栈
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> subList = new ArrayList<>();

            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    subList.add(node.val);
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                }
                res.add(subList);
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    subList.add(node.val);

                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                }
                res.add(subList);
            }
        }
        return res;
    }

    //public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    //    List<List<Integer>> list = new ArrayList<>();
    //    if (root == null) {
    //        return list;
    //    }
    //    //栈1来存储右节点到左节点的顺序
    //    Stack<TreeNode> stack1 = new Stack<>();
    //    //栈2来存储左节点到右节点的顺序
    //    Stack<TreeNode> stack2 = new Stack<>();
    //
    //    //根节点入栈
    //    stack1.push(root);
    //
    //    //每次循环中，都是一个栈为空，一个栈不为空，结束的条件两个都为空
    //    while (!stack1.isEmpty() || !stack2.isEmpty()) {
    //        List<Integer> subList = new ArrayList<>(); // 存储这一个层的数据
    //        TreeNode cur;
    //
    //        if (!stack1.isEmpty()) { //栈1不为空，则栈2此时为空，需要用栈2来存储从下一层从左到右的顺序
    //            while (!stack1.isEmpty()) {    //遍历栈1中所有元素，即当前层的所有元素
    //                cur = stack1.pop();
    //                subList.add(cur.val);    //存储当前层所有元素
    //
    //                if (cur.left != null) {    //左节点不为空加入下一层
    //                    stack2.push(cur.left);
    //                }
    //                if (cur.right != null) {    //右节点不为空加入下一层
    //                    stack2.push(cur.right);
    //                }
    //            }
    //            list.add(subList);
    //        } else {//栈2不为空，则栈1此时为空，需要用栈1来存储从下一层从右到左的顺序
    //            while (!stack2.isEmpty()) {
    //                cur = stack2.pop();
    //                subList.add(cur.val);
    //
    //                if (cur.right != null) {//右节点不为空加入下一层
    //                    stack1.push(cur.right);
    //                }
    //                if (cur.left != null) { //左节点不为空加入下一层
    //                    stack1.push(cur.left);
    //                }
    //            }
    //            list.add(subList);
    //        }
    //    }
    //    return list;
    //}

    @Test
    public void test() {
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, left, right);

        List<List<Integer>> res = zigzagLevelOrder1(root);
        System.out.println(JSON.toJSON(res));
    }
}