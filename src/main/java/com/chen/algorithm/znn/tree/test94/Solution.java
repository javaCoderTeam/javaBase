package com.chen.algorithm.znn.tree.test94;

import com.alibaba.fastjson.JSON;
import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/94er-cha-shu-de-zhong-xu-bian-li-by-wulin-v/
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * @Auther: zhunn
 * @Date: 2020/10/28 16:25
 * @Description: 二叉树的中序遍历：1-递归；2-迭代
 */
public class Solution {

    /**
     * 1-递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    /**
     * 2-迭代，栈(推荐)
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {      // 当前节点不为空，一直将左子树入栈
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode temp = stack.pop();    // 出栈
            res.add(temp.val);          // 操作数据
            curr = temp.right;          // 对出栈的节点检查是有否还有左节点，有的话继续入栈，没有的话就操作叶子节点的上一个节点
        }
        return res;
    }


    //public List<Integer> inorderTraversal3(TreeNode root) {
    //    List<Integer> list = new ArrayList<>();
    //    Stack<TreeNode> s = new Stack<>();
    //    while (root != null || !s.isEmpty()) {
    //        while (root != null) {      //当前节点不为空，一直将左子树入栈
    //            s.push(root);
    //            root = root.left;
    //        }
    //        TreeNode tem = s.pop();  //出栈
    //        list.add(tem.val);     // 操作数据
    //        root = tem.right;        //对出栈的节点检查是有否还有左节点，有的话继续入栈，没有的话就操作叶子节点的上一个节点
    //    }
    //    return list;
    //}

    @Test
    public void test() {
        TreeNode right = new TreeNode(2, new TreeNode(3), null);
        TreeNode root = new TreeNode(1, null, right);

        List<Integer> res = inorderTraversal2(root);
        System.out.println(JSON.toJSON(res));
    }

}
