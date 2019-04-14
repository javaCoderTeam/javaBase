package com.chen.dataStructure.hash;

/**
 * 有序链表
 * @author :  chen weijie
 * @Date: 2019-04-14 01:40
 */
public class SortLink {

    private LinkNode first;
    public SortLink(){
        first = null;
    }


    class LinkNode{
        private int iData;
        public LinkNode next;
        public LinkNode(int iData){
            this.iData = iData;
        }
        public int getKey(){
            return iData;
        }
        public void displayLink(){
            System.out.println(iData + " ");
        }
    }

    public void displayLink(){
        System.out.println("Link(First->Last)");
        LinkNode current = first;
        while(current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insert(LinkNode node){
        int key = node.getKey();
        LinkNode previous = null;
        LinkNode current = first;
        while(current != null && current.getKey() < key){
            previous = current;
            current = current.next;
        }
        if(previous == null){
            first = node;
        }else{
            previous.next = node;
        }
        node.next = current;
    }

    public void delete(int key){
        LinkNode previous = null;
        LinkNode current = first;
        if(isEmpty()){
            System.out.println("Linked is Empty!!!");
            return;
        }
        while(current != null && current.getKey() != key){
            previous = current;
            current = current.next;
        }
        if(previous == null){
            first = first.next;
        }else{
            previous.next = current.next;
        }
    }

    public LinkNode find(int key){
        LinkNode current = first;
        while(current != null && current.getKey() <= key){
            if(current.getKey() == key){
                return current;
            }
            current = current.next;
        }
        return null;
    }


}
