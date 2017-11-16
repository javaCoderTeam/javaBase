package com.chen.api.util.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chen Weijie on 2017/8/6.
 */
public class RegexTest1 {


    @Test
    public void testMatches(){
        String regex = "[1-9][0-1]*[.]?[0-9]*";
        String str1 ="12r34a5";
        if (regex.matches(str1)){
            System.out.println("matches:"+str1);
        }else {
            str1=  str1.replaceAll("\\D+","");
            System.out.println(" not matches:"+str1);
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





}
