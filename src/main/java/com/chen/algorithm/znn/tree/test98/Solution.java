package com.chen.algorithm.znn.tree.test98;

import com.chen.algorithm.znn.tree.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @Auther: zhunn
 * @Date: 2020/10/29 16:35
 * @Description: 验证二叉搜索树：1-递归，2-中序遍历
 */
public class Solution {

    /**
     * 1-递归：左子树里所有节点的值均小于根结点的值，右子树里所有节点的值均大于根结点的值
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        return isValid(root, null, null);
    }
    private boolean isValid(TreeNode root, Integer min, Integer max) {

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

    /**
     * 2-中序遍历：遍历后是升序，后一个值不得有小于前一个值
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    @Test
    public void test() {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(7, new TreeNode(6), new TreeNode(20));
        TreeNode root = new TreeNode(3, left, right);

        boolean res = isValidBST2(root);
        System.out.println(res);
    }

}
