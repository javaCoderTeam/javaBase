package com.chen.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * https://zhuanlan.zhihu.com/p/29425290
 *
 * @author :  chen weijie
 * @Date: 2020-07-09 01:51
 */
public class RevertTree {


    class Node {
        private String value;
        private List<Node> children;

        public Node(String value, List<Node> children) {
            this.value = value;
            this.children = children;
        }

        public Node() {
        }

        public String value() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void addChild(Node node) {
            if (node == null) {
                return;
            }
            this.children.add(node);
        }

        public List<Node> getChildren() {
            return this.children;
        }
    }

    public void dfs(Node root) {

        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.value);

            if (node.children != null && node.children.size() != 0) {
                List<Node> children = node.children;
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
    }

    public void bfs(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.value);

            List<Node> children = node.children;

            for (Node child : children) {
                queue.add(child);
            }
        }
    }


}
