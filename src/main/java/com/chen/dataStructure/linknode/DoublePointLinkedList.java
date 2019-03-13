package com.chen.dataStructure.linknode;

/**
 * 双端队列
 *
 * @author :  chen weijie
 * @Date: 2019-03-13 11:12 PM
 */
public class DoublePointLinkedList {


    private Node head;

    private Node tail;

    private int size;


    private class Node {

        private Object data;

        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }


    public DoublePointLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    /**
     * 头部添加节点
     *
     * @param data
     */
    public void addHead(Object data) {

        Node node = new Node(data);

        //如果链表为空，那么头节点和尾节点都是该新增节点
        if (size == 0) {
            size = 0;
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
            size++;
        }
    }


    public void addTail(Object data) {

        Node node = new Node(data);

        //如果链表为空，那么头节点和尾节点都是该新增节点
        if (size == 0) {
            size = 0;
            head = node;
            tail = node;
        } else {
            node.next = tail;
            tail = node;
            size++;
        }

    }


    /**
     * 删除头节点
     *
     * @return
     */
    public boolean deleteHead() {

        if (size == 0) {
            return false;
        }

        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }


    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * 获得链表的节点个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 显示节点信息
     */

    public void display() {
        if (size > 0) {
            Node node = head;
            int tempSize = size;
            if (tempSize == 1) {//当前链表只有一个节点
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
        } else {//如果链表一个节点都没有，直接打印[]
            System.out.println("[]");
        }
    }


}
