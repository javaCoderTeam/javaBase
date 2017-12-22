package com.chen.api.util.regex;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chen Weijie on 2017/8/6.
 */
public class RegexTest1 {


    @Test
    public void testMatches() {
        String regex = "[1-9][0-1]*[.]?[0-9]*";
        String str1 = "12r34a5";
        if (regex.matches(str1)) {
            System.out.println("matches:" + str1);
        } else {
            str1 = str1.replaceAll("\\D+", "");
            System.out.println(" not matches:" + str1);
        }
    }

    @Test
    public void testCompile() {
        String str1 = "1r234a5";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str1);
        while (matcher.find()) {
            System.out.println("first:" + matcher.group());
        }
    }

    @Test
    public void testFindAndMatch() {
        Pattern p = Pattern.compile("\\d\\d\\d");
        Matcher m = p.matcher("a123b");
        System.out.println(m.find());
        System.out.println(m.matches());

        p = Pattern.compile("^\\d\\d\\d$");
        m = p.matcher("123");
        System.out.println(m.find());
        System.out.println(m.matches());
    }

    @Test
    public void testNumber() {
//        String patterStr = "^([0-9]\\d*\\.\\d*)|(0\\.\\d*[0-9]\\d*)|([0-9]\\d*)$";
        String patterStr = "^[-]?[0.0-9.0]+$";
        String[] strings = {"3", "4", "5", "1.0", "0.2", "44", "-2", "1.111", "100.5", "0", "0.0", "-0.2", "d", "4200.22222"};
        Arrays.asList(strings).forEach(str -> System.out.println(str + ",matches:" + str.matches(patterStr)));
    }

    /**
     * 测试换行模式
     */
    @Test
    public void testPattern() {
        Matcher m = Pattern.compile("(?ms)^.*$").matcher("a\r\nb\r\nc");
        while (m.find()) {
            System.out.println("matched:" + m.group());
        }
    }


    /**
     * 测试回溯
     */
    @Test
    public void testMatch() {
        String str = "12345";

        Pattern pattern = Pattern.compile("(\\d{1,3})(\\d{1,3})");

        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println("count:" + matcher.groupCount());
            for (int i = 0; i < matcher.groupCount(); i++) {
                System.out.println(matcher.group(i));
            }
        }
    }


}
