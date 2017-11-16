package com.chen.api.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式类
 *
 * @author Chen WeiJie
 * @date 2017-11-16 21:31
 **/
public class TestRegularExpression {


    //http://blog.csdn.net/allwefantasy/article/details/3136570/
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("输入的字符串为空！");
            System.exit(0);
        }
        System.out.println("输入的字符串为： \"" + args[0] + "\"");
        for (int i = 1; i < args.length; i++) {
            System.out.println("正则表达式为: \"" + args[i] + "\"");
            Pattern p = Pattern.compile(args[i]);
            Matcher m = p.matcher(args[0]);
            while (m.find()) {
                System.out.println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
            }
        }
    }


}
