package com.chen.dataStructure.stack;

/**
 * 利用栈实现字符串逆序
 *
 * @author :  chen weijie
 * @Date: 2019-03-06 12:59 AM
 */
public class RevertString {


    public static void main(String[] args) {


        String str = "how are you ";
        char[] charArray = str.toCharArray();
        ArrayStack myStack = new ArrayStack();
        for (char c : charArray) {
            myStack.push(c);
        }

        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop());
        }

    }

}
