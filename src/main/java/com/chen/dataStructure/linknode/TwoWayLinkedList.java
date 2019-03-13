package com.chen.dataStructure.linknode;

/**
 * 双向链表
 *
 * @author :  chen weijie
 * @Date: 2019-03-13 11:49 PM
 */
public class TwoWayLinkedList {


    private int size;

    private Node head;

    private Node tail;


    public class Node {

        private Object data;

        private Node next;

        private Node prew;


        public Node(Object data) {
            this.data = data;
        }
    }


    public TwoWayLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }


    public void addHead(Object data) {

        Node node = new Node(data);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            head.prew = node;
            node.next = head;
            head = node;
        }

        size++;
    }


    public void addTail(Object data) {

        Node node = new Node(data);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.prew = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }


    public Node deleteHead() {

        Node temp = head;
        if (size > 0) {
            head = head.next;
            head.prew = null;
            size--;
        }
        return temp;
    }

    public Node deleteTail() {

        Node temp = tail;
        if (size > 0) {
            tail = head.prew;
            tail.next = null;
            size--;
        }
        return temp;
    }


}
