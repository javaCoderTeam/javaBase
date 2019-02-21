package com.chen.dataStructure.linknode;

/**
 * @Author chenweijie
 * @Date 2017/10/16 1:52
 */
public class Node {

    //数据域
    private int Data;
    //指针域
    private Node Next;

    public Node(int Data) {
        this.Data = Data;
    }

    public int getData() {
        return Data;
    }

    public void setData(int data) {
        Data = data;
    }

    public Node getNext() {
        return Next;
    }

    public void setNext(Node next) {
        Next = next;
    }
}
