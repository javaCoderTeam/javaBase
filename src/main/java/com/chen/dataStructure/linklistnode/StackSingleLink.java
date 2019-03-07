package com.chen.dataStructure.linklistnode;

/**
 * 用单向链表实现栈
 * 栈的pop()方法和push()方法，对应于链表的在头部删除元素deleteHead()以及在头部增加元素addHead()。
 *
 * @author :  chen weijie
 * @Date: 2019-03-08 12:57 AM
 */
public class StackSingleLink {


    private SingleLinkedList linkedList;


    public StackSingleLink(SingleLinkedList linkedList) {
        this.linkedList = linkedList;
    }

    public void push(Object data) {
        linkedList.addHead(data);
    }


    public Object pop() {
        return linkedList.deleteHead();
    }


    public boolean isEmpty() {
        return linkedList.isEmpty();
    }


}
