package com.chen.dataStructure.linklistnode;

/**
 * 单链表的具体实现
 *
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
     *
     * @param data
     * @return
     */
    public Object addHead(Object data) {

        Node newHead = new Node(data);
        if (size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;

        return head;
    }


    /**
     * 删除链表头节点
     *
     * @return
     */
    public Object deleteHead() {
        Object data = head.data;
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

        Node current = head;

        int tempSize = size;
        while (tempSize > 0) {
            if (data.equals(current.data)) {
                return current;
            } else {
                current = current.next;
                tempSize--;
            }

        }
        return null;

    }

    /**
     * 删除指定元素，删除成功返回true
     *
     * @param data
     * @return
     */
    public boolean delete(Object data) {

        if (size == 0) {
            return true;
        }
        Node current = head;
        Node previous = head;

        while (current.data != data) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }

        //如果删除的节点是第一个节点
        if (current == head) {
            head = current.next;
            size--;
        } else {
            //删除的节点不是第一个节点
            previous.next = current.next;
            size--;
        }
        return true;
    }


    /**
     * 判断链表是不是空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }


    //显示节点信息
    public void display() {
        if (size > 0) {
            Node node = head;
            int tempSize = size;
            //当前链表只有一个节点
            if (tempSize == 1) {
                System.out.println("[" + node.data + "]");
                return;
            }
            while (tempSize > 0) {
                if (node.equals(head)) {
                    System.out.print("[" + node.data + "->");
                } else if (node.next == null) {
                    System.out.print(node.data + "]");
                } else {
                    System.out.print(node.data + "->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        } else {
            //如果链表一个节点都没有，直接打印[]
            System.out.println("[]");
        }

    }


    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHead("A");
        singleLinkedList.addHead("B");
        singleLinkedList.addHead("C");
        singleLinkedList.addHead("D");

        singleLinkedList.display();

        singleLinkedList.delete("B");

        singleLinkedList.display();

        System.out.println("find:" + singleLinkedList.find("D"));


    }












}
