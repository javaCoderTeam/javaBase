package com.chen.api.util.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhuningning
 * date 2017-11-18
 */
public class RegexTest3 {

    @Test
    public void test1() {

        Pattern pattern = Pattern.compile("\\d+");

        Matcher matcher = pattern.matcher("56");
        //表示整个字符串是否可以与模式匹配
        boolean b = matcher.matches();
        matcher.group();
//        System.out.println("b=="+b);
        System.out.println(matcher.group());

        while (matcher.find()) {
            System.out.println("result=" + matcher.group());
            System.out.println("count=" + matcher.groupCount());
        }
    }


    @Test
    public void test2() {

        Pattern pattern = Pattern.compile("\\w+");

        Matcher matcher = pattern.matcher("Evening is full of the linnet's wings");

        while (matcher.find()) {
            System.out.println("match find:" + matcher.group());
        }

        int i = 0;
        while (matcher.find(i)) {
            System.out.println(matcher.group());
            i++;
        }

    }


    @Test
    public void test3() {

        String poem =
                "Twas brillig, and the slithy toves/n" +
                        "Did gyre and gimble in the wabe./n" +
                        "All mimsy were the borogoves,/n" +
                        "And the mome raths outgrabe./n/n" +
                        "Beware the Jabberwock, my son,/n" +
                        "The jaws that bite, the claws that catch./n" +
                        "Beware the Jubjub bird, and shun/n" +
                        "The frumious Bandersnatch.";

        Pattern pattern = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))");

        Matcher matcher = pattern.matcher(poem);

        while (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(matcher.group(i));
            }
        }
    }


}
