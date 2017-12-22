package com.chen.api.util.regex;

import org.junit.Test;

import java.util.Arrays;
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

        Boolean flag = Pattern.matches("\\d+", "test string  34 5");

        //表示整个字符串是否可以与模式匹配
        boolean b = matcher.matches();
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


    @Test
    public void test4() {
        String[] input = new String[]{
                "Java has regular expressions in 1.4",
                "regular expressions now expressing in Java",
                "Java represses oracular expressions"
        };
        Pattern p1 = Pattern.compile("re\\w*"),
                p2 = Pattern.compile("Java.*");
        for (int i = 0; i < input.length; i++) {
            System.out.println("input " + i + ": " + input[i]);
            Matcher
                    m1 = p1.matcher(input[i]),
                    m2 = p2.matcher(input[i]);
            while (m1.find()) {
                System.out.println("m1.find() '" + m1.group() +
                        "' start = " + m1.start() + " end = " + m1.end());
            }

            while (m2.find()) {
                System.out.println("m2.find() '" + m2.group() +
                        "' start = " + m2.start() + " end = " + m2.end());
            }
            // No reset() necessary
            if (m1.lookingAt()) {
                System.out.println("m1.lookingAt() start = "
                        + m1.start() + " end = " + m1.end());
            }
            if (m2.lookingAt()) {
                System.out.println("m2.lookingAt() start = "
                        + m2.start() + " end = " + m2.end());
            }
            // No reset() necessary
            if (m1.matches()) {
                System.out.println("m1.matches() start = "
                        + m1.start() + " end = " + m1.end());
            }

            if (m2.matches()) {
                System.out.println("m2.matches() start = "
                        + m2.start() + " end = " + m2.end());
            }
        }
    }


    @Test
    public void test5() {
        String input = "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.asList(Pattern.compile("!!").split(input)));
        // Only do the first three:
        System.out.println(Arrays.asList(Pattern.compile("!!").split(input, 3)));
        System.out.println(Arrays.asList("Aha! String has a split() built in!".split(" ")));

    }


    @Test
    public void test6() {

        String s = "! Here's a block of text to use as input to\n" +
                "  the regular expression matcher. Note that we'll\n" +
                "  first extract the block of text by looking for\n" +
                "  the special delimiters, then process the\n" +
                "  extracted block. !";
        Matcher mInput = Pattern.compile("/*!(.*)!*/", Pattern.DOTALL).matcher(s);
        // Captured by parentheses
        if (mInput.find()){
            s = mInput.group(1);
        }

        // Replace two or more spaces with a single space:
        s = s.replaceAll(" {2,}", " ");

        // Replace one or more spaces at the beginning of each
        // line with no spaces. Must enable MULTILINE mode:
        s = s.replaceAll("(?m)^ +", "");
        System.out.println(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        // Process the find information as you
        // perform the replacements:
        while (m.find())
            m.appendReplacement(sbuf, m.group().toUpperCase());
        // Put in the remainder of the text:
        m.appendTail(sbuf);
        System.out.println(sbuf);

    }


    @Test
    public void test7() {
        Matcher m = Pattern.compile("[frb][aiu][gx]")
                .matcher("fix the rug with bags");

        while (m.find()) {
            System.out.println(m.group());
        }

        m.reset("fix the rig with rags");

        while (m.find()) {
            System.out.println(m.group());
        }
    }


    @Test
    public void test8(){



    }










}
