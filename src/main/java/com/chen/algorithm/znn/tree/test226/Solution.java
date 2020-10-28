package com.chen.algorithm.znn.tree.test226;

import com.alibaba.fastjson.JSON;
import com.chen.algorithm.znn.tree.TreeNode;
import org.apache.zookeeper.server.quorum.flexible.QuorumHierarchical;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/solution/dong-hua-yan-shi-liang-chong-shi-xian-226-fan-zhua/
 *
 * @Auther: zhunn
 * @Date: 2020/10/28 17:58
 * @Description: 翻转二叉树：1-递归；2-迭代
 */
public class Solution {

    /**
     * 1-递归
     *
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

    /**
     * 2-迭代
     *
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }

    //public TreeNode invertTree3(TreeNode root) {
    //    if (root == null) {
    //        return null;
    //    }
    //    //将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
    //    LinkedList<TreeNode> queue = new LinkedList<>();
    //    queue.add(root);
    //    while (!queue.isEmpty()) {
    //        //每次都从队列中拿一个节点，并交换这个节点的左右子树
    //        TreeNode tmp = queue.poll();
    //        TreeNode left = tmp.left;
    //        tmp.left = tmp.right;
    //        tmp.right = left;
    //        //如果当前节点的左子树不为空，则放入队列等待后续处理
    //        if (tmp.left != null) {
    //            queue.add(tmp.left);
    //        }
    //        //如果当前节点的右子树不为空，则放入队列等待后续处理
    //        if (tmp.right != null) {
    //            queue.add(tmp.right);
    //        }
    //
    //    }
    //    //返回处理完的根节点
    //    return root;
    //}

    @Test
    public void test() {
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, left, right);

        TreeNode res = invertTree2(root);
        System.out.println(JSON.toJSON(res));
    }
}
