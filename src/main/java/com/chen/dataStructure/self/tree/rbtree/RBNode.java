package com.chen.dataStructure.self.tree.rbtree;

/**
 * 红黑树节点类
 * <p>
 * 节点类和二叉树的节点类差不多，只不过在其基础上增加了一个 boolean 类型的变量来表示节点的颜色
 *
 * @author :  chen weijie
 * @Date: 2019-04-10 12:18 AM
 */
public class RBNode<T extends Comparable<T>> {

    /**
     * 颜色
     */
    boolean color;

    /**
     * 关键值
     */
    T key;

    /**
     * 左子节点
     */
    RBNode<T> left;

    /**
     * 右子节点
     */
    RBNode<T> right;

    /**
     * 父节点
     */
    RBNode<T> parent;


    RBNode<T> root;


    public RBNode(boolean color, T key, RBNode<T> left, RBNode<T> right, RBNode<T> parent) {
        this.color = color;
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }


    /**
     * 获取节点的关键值
     *
     * @return
     */
    public T getKey() {
        return key;
    }

    /**
     * 打印节点的关键值和颜色信息
     */
    @Override
    public String toString() {
        return "" + key + (this.color ? "R" : "B");
    }


    /*************对红黑树节点x进行左旋操作 ******************/

    /***
     *
     * 左旋示意图：对节点x进行左旋
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     *
     * 左旋做了三件事：
     * 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)
     * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
     * 3. 将y的左子节点设为x，将x的父节点设为y
     */
    private void leftRotate(RBNode<T> x) {
        //1. 将y的左子节点赋给x的右子节点，并将x赋给y左子节点的父节点(y左子节点非空时)
        RBNode<T> y = x.right;

        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        //2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else {
            if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }

        // 3. 将y的左子节点设为x，将x的父节点设为y
        y.left = x;
        x.parent = y;
    }


    /*************对红黑树节点y进行右旋操作 ******************/
    /**
     * 左旋示意图：对节点y进行右旋
     * p                   p
     * /                   /
     * y                   x
     * / \                 / \
     * x  ry   ----->      lx  y
     * / \                     / \
     * lx  rx                   rx ry
     * 右旋做了三件事：
     * 1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
     * 2. 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
     * 3. 将x的右子节点设为y，将y的父节点设为x
     */
    private void rightRotate(RBNode<T> y) {

        //1. 将y的左子节点赋给x的右子节点，并将y赋给x右子节点的父节点(x右子节点非空时)
        RBNode<T> x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }

        //2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
        x.parent = y.parent;

        if (y.parent == null) {
            //如果y的父节点为空(即y为根节点)，则旋转后将x设为根节点
            this.root = x;
        } else {
            if (y == y.parent.left) {
                //则将x也设置为左子节点
                y.parent.left = x;
            } else {
                //否则将x设置为右子节点
                y.parent.right = x;
            }
        }

        //3. 将x的左子节点设为y，将y的父节点设为y
        x.right = y;
        y.parent = x;

    }


}
