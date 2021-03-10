package com.chen.algorithm.znn;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewTest {

    /*
    [
{id:1, name:xx1, pid:0},
{id:2, name:xx2, pid:0},
{id:3, name:xx3, pid:1},
{id:4, name:xx4, pid:3},
{id:5, name:xx5, pid:4},
]
     */

    class Node{
        private int id;
        private String name;
        private int pid;
        private List<Node> children;
        public Node(){}
        public Node(int pid){
            this.pid = pid;
        }

        public Node(int id,String name, int pid){
            this.id = id;
            this.name = name;
            this.pid = pid;
        }
    }

    public Node getNode(List<Node> nodeList){
        if(nodeList == null || nodeList.size() == 0){
            return null;
        }
        Map<Integer,List<Node>> nodeMap = new HashMap<>();
        Map<Integer, Node> originNodeMap = new HashMap<>();

        for(int i =0;i<nodeList.size();i++){
            Node originNode = nodeList.get(i);
            int pid = originNode.pid;
            originNodeMap.put(originNode.id, originNode);

            if(!nodeMap.containsKey(pid)){
                nodeMap.put(pid, Arrays.asList(originNode));
            }else{
                nodeMap.get(pid).add(originNode);
            }
        }
        Node root = new Node(-1,"root",-2);
        nodeMap.keySet().forEach(pid->{
            Node fNode = originNodeMap.get(pid);
            if(fNode == null){
                fNode = new Node(pid,"xxxpid",-1);
                if(root.children == null){
                    root.children = Arrays.asList(fNode);
                }else{
                    root.children.add(fNode);
                }
            }
             fNode.children = nodeMap.get(pid);
        });
        return root;
    }

    @Test
    public void test(){

//    [
//        {id:1, name:xx1, pid:0},
//        {id:2, name:xx2, pid:0},
//        {id:3, name:xx3, pid:1},
//        {id:4, name:xx4, pid:3},
//        {id:5, name:xx5, pid:4},
//]
        System.out.println(isHuiwen("12321"));
    }

    public boolean isPalling(String s){
        if(s == null || s.length() == 0){
            return false;
        }

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int x = 0;x<len;x++){
            for(int i =0;i+x<len;i++){
                int j = i+x;
                if(x == 0){
                    dp[i][j] = true;
                }else if(x == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    dp[i][j] =(dp[i+1][j-1]) &&s.charAt(i) == s.charAt(j);
                }
            }
        }
        return dp[0][len-1];
    }

    public boolean isHuiwen(String s){
        if(s == null || s.length() == 0){
            return false;
        }
        if(s.length() == 1){
            return true;
        }
        int len = s.length();
        int j =len;
        for(int i =0;i<len/2;i++){
            char head = s.charAt(i);
            char tail = s.charAt(j-1);
            if(head != tail){
                return false;
            }
            j--;
        }
        return true;
    }
}
