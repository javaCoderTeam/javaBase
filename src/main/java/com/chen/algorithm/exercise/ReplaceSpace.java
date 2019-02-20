package com.chen.algorithm.exercise;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author :  chen weijie
 * @Date: 2019-02-21 12:19 AM
 */
public class ReplaceSpace {


    public static String solution(String str) {

        if (str == null || "".equals(str)) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String str = "we are very happy!";
        str = solution(str);
        System.out.println("转换后的字符串为：" + str);
    }


}
