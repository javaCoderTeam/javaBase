package com.chen.algorithm.study.test206;

/**
 * @author :  chen weijie
 * @Date: 2019-11-28 18:06
 */
public class Solution4 {




    public void solution(ListNode head){

        if (head==null){
            return;
        }


        ListNode pre = null;

        while (head!=null){

            ListNode temp = head.next;
            head.next =pre;
            pre=head;
            head= temp;

        }








    }




}
