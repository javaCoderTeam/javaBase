package com.chen.dataStructure.linklistnode;

/**
 * 单链表的具体实现
 * @author :  chen weijie
 * @Date: 2019-02-21 11:35 PM
 */
public class SingleLinkedList {

    //链表节点的个数
    private int size;

    //头节点
    private Node head;



    private class Node {

        //每个节点的数据
        private Object data;

        //每个节点指向下一个节点的连接
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }


    /**
     * 单链表的表头添加元素
     * @param data
     * @return
     */
    public Object addHead(Object data) {

        Node newHead = new Node(data);

        if (size == 0) {
            head = newHead;
        } else {
            //新头节点的下个节点是旧的head节点
            newHead.next = head;
            //新加入的节点为SingleLinkedList的头节点
            head = newHead;
        }

        size++;
        return data;
    }


    /**
     * 删除链表头节点
     * @return
     */
    public Object deleteHead() {

        Object data = head.data;

        //新头节点为旧头节点的下个节点
        head = head.next;

        size--;
        return data;
    }

    /**
     * 找到指定元素返回节点Node，找不到返回null
     *
     * @param data
     * @return
     */
    public Node find(Object data) {

        Node curr = head;
        //只是查找，不改变链表的个数，所以要新建tempSize变量
        int tempSize = size;

        while (tempSize > 0) {
            if (data.equals(curr.data)) {
                return curr;
            }
            curr = curr.next;
            tempSize--;
        }
        return null;
    }

    /**
     * 删除指定元素，删除成功返回true
     * @param data
     * @return
     */
    public boolean delete(Object data){










        return false;
    }


    /**
     * 判断链表是不是空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }









}
