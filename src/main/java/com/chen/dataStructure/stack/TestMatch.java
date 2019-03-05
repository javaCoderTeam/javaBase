package com.chen.dataStructure.stack;

/**
 * 利用栈判断分隔符是否匹配
 * 比如：<abc[123]abc>这是符号相匹配的，如果是 <abc[123>abc] 那就是不匹配的。
 * <p>
 * 　对于 12<a[b{c}]>，我们分析在栈中的数据：遇到匹配正确的就消除
 *
 * @author :  chen weijie
 * @Date: 2019-03-06 1:04 AM
 */
public class TestMatch {


    //遇到左边分隔符了就push进栈，遇到右边分隔符了就pop出栈，看出栈的分隔符是否和这个有分隔符匹配


    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(3);

        String str = "12<a[b{c}]>";

        char[] chars = str.toCharArray();

        for (char c : chars) {

            switch (c) {

                case '{':
                case '[':
                case '<':
                    arrayStack.push(c);
                    break;
                case '}':
                case ']':
                case '>':
                    if (!arrayStack.isEmpty()) {
                        char ch = arrayStack.pop().toString().toCharArray()[0];
                        if (c == '}' && ch != '{' || c == ']' && ch != '[' ||
                                c == '>' && ch != '<') {
                            System.out.println("Error:" + ch + "-" + c);

                        }
                    }
                    break;
                default:
                    break;


            }


        }


    }


}
