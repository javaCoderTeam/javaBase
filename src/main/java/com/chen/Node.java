package com.chen;

/**
 * @author :  chen weijie
 * @Date: 2020-07-28 21:15
 */
public class Node {


    private Integer value;

    private Node next;


    public Node(int val, Node next) {
        this.value = val;
        this.next = next;
    }


    public static void main(String[] args) {

        //4 5 6
        Node a6 = new Node(6, null);
        Node a5 = new Node(5, a6);
        Node a4 = new Node(4, a5);

        // 4 6 7 9
        Node b9 = new Node(9, null);
        Node b7 = new Node(7, b9);
        Node b6 = new Node(6, b7);
        Node b4 = new Node(4, b6);


        Node res = add(a4, b4);

        while (res != null) {
            System.out.println(res.value);
            res = res.next;

        }
    }


    public static Node add(Node node1, Node node2) {

        Node res = new Node(-1, null);
        Node resNode = res;
        node1 = revertLink(node1);
        node2 = revertLink(node2);
        int temp = 0;
        while (node1 != null && node2 != null) {
            int val = node1.value + node2.value + temp;
            if (val >= 10) {
                temp = 1;
                val = val % 10;
            } else {
                temp = 0;
            }

            resNode.next = new Node(val, null);
            node1 = node1.next;
            node2 = node2.next;
            resNode = resNode.next;
        }


        while (node1 != null) {
            int val = node1.value + temp;
            if (val >= 10) {
                temp = 1;
                val = val % 10;
            } else {
                temp = 0;
            }
            resNode.next = new Node(val, null);
            node1 = node1.next;
            resNode = resNode.next;
        }

        while (node2 != null) {
            int val = node2.value + temp;
            if (val >= 10) {
                temp = 1;
                val = val % 10;
            } else {
                temp = 0;
            }
            resNode.next = new Node(val, null);
            node2 = node2.next;
            resNode = resNode.next;
        }


        return revertLink(res.next);
    }


    private static Node revertLink(Node node) {

        Node pre = null;

        while (node != null) {
            Node temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }

}
