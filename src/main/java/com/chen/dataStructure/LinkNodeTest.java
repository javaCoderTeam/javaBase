package com.chen.dataStructure;

/**
 * http://blog.csdn.net/guyuealian/article/details/51119499(单链表的反转)
 * @Author chenweijie
 * @Date 2017/10/16 1:37
 * @Description
 * 基本思路是：将当前节点cur的下一个节点 cur.getNext()缓存到temp后，然后更改当前节点指针指向上一结点pre。
 * 也就是说在反转当前结点指针指向前，先把当前结点的指针域用tmp临时保存，以便下一次使用，其过程可表示如下：
    pre：上一结点
    cur: 当前结点
    tmp: 临时结点，用于保存当前结点的指针域（即下一结点）
 */
public class LinkNodeTest {

    public static void main(String[] args) {
        Node head =new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

    //打印反转前的列表
        Node h =head;
        while (null!=h){
            System.out.println(h.getData()+" ");
            h =h.getNext();
        }

        // 调用反转方法
        head = reverse(head);

        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }


    }




    /**
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     */
    public static Node reverse(Node head){

        if (head ==null)
            return head;

        //上一节点
        Node pre =head;
        //当前节点
        Node cur =head.getNext();
        //临时节点  用于保存当前节点的指针域（即下一节点）
        Node tmp;

        //当前节点为null 说明位于尾节点
        while (cur!=null){
            tmp =cur.getNext();
            //反转指针域的指向
            cur.setNext(pre);
            //指针向下移动
            pre =cur;
            cur =tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);

        return pre;
    }








}
