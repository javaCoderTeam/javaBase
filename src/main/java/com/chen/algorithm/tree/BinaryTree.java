package com.chen.algorithm.tree;

/**
 * 二叉树搜索树
 *
 * @author :  chen weijie
 * @Date: 2019-04-08 11:22 AM
 */
public class BinaryTree implements Tree {


    private Node root;


    @Override
    public Node find(int key) {

        Node current = root;

        while (current != null) {
            //当前值比查找值大，搜索左子树
            if (current.data > key) {
                current = current.leftNode;
                //当前值比查找值小，搜索右子树
            } else if (current.data < key) {
                current = current.rightNode;
            } else {
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean insert(int data) {

        Node newNode = new Node(data);
        //当前树为空树，没有任何节点
        if (root == null) {
            root = newNode;
            return true;
        } else {
            Node current = root;
            Node parentNode = null;

            while (current != null) {
                parentNode = current;
                //当前值比插入值大，搜索左子节点
                if (current.data > data) {
                    current = current.leftNode;
                    //左子节点为空，直接将新值插入到该节点
                    if (current == null) {
                        parentNode.leftNode = newNode;
                        return true;
                    }
                } else {
                    current = current.rightNode;
                    if (current == null) {
                        parentNode.rightNode = newNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean delete(int key) {
        return false;
    }


    /**
     * 中序遍历
     *
     * @param current
     */
    public void infixOrder(Node current) {

        if (current != null) {
            infixOrder(current.leftNode);
            System.out.println(current.data + " ");
            infixOrder(current.rightNode);
        }
    }


    /**
     * 前序遍历
     *
     * @param current
     */
    public void preOrder(Node current) {
        if (current != null) {
            System.out.println(current.data + " ");
            preOrder(current.leftNode);
            preOrder(current.rightNode);
        }
    }

    /**
     * 后序遍历
     *
     * @param current
     */
    public void postOrder(Node current) {

        if (current != null) {
            postOrder(current.leftNode);
            postOrder(current.rightNode);
            System.out.println(current.data + " ");
        }
    }


    /**
     * 找到最大的节点
     *
     * @return
     */
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.rightNode;
        }
        return maxNode;
    }

    /**
     * 查找最小节点
     *
     * @return
     */
    public Node finMin() {
        Node current = root;
        Node minNode = current;
        while (current != null) {
            minNode = current;
            current = current.leftNode;
        }
        return minNode;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);

        System.out.println("infixOrder:");
        bt.infixOrder(bt.root);
        System.out.println("preOrder:");
        bt.preOrder(bt.root);
        System.out.println("postOrder:");
        bt.postOrder(bt.root);


        System.out.println("max:" + bt.findMax().data);
        System.out.println("min:" + bt.finMin().data);
        System.out.println(bt.find(100));
        System.out.println(bt.find(200));


    }


}
