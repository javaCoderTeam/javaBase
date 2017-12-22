package com.chen.api.util.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式类 (//http://blog.csdn.net/allwefantasy/article/details/3136570/)
 *
 * @author Chen WeiJie
 * @date 2017-11-16 21:31
 **/
public class TestRegularExpression {


    /**
     * 测试split方法
     */
    @Test
    public void test1() {

        String input = "This !! unusual use!!of exclamation!!points";

        Pattern pattern = Pattern.compile("!!");
        String[] arr = pattern.split(input);
        StringBuffer sb = new StringBuffer();
        pattern.matcher(input).appendReplacement(sb, arr[0].toUpperCase()).appendTail(sb);

        String stringSpit = "this is a String!";
        String[] arr2 = stringSpit.split("\\n");

    }


    /**
     * 测试Matcher.reset()方法
     */
    @Test
    public void test2() {

        Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");

        while (m.find()) {
            System.out.println(m.group());
        }

        m.reset("fix the rig with rags");

        while (m.find()) {
            System.out.println(m.group());
        }
    }


}
