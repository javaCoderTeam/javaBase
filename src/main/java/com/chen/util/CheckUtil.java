package com.chen.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 检查工具类
 * Created by chenwj3 on 2017/1/18.
 */
public class CheckUtil {


    /**
     * 判断字符串是不是null或无字符（trim）
     *
     * @param o
     * @return
     */
    public static Boolean isEmpty(String o) {

        return (o == null || o.trim().length() == 0);

    }

    /**
     * 判断字符串是不是数字
     *
     * @param str
     * @return
     */
    public static Boolean checkNum(String str) {

        return !isEmpty(str) && str.matches("^\\d+$");
    }

    /**
     * 判断字符串是否为数字,包括整数和小数.
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^[-]?[0.0-9.0]+$");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("1"));
        System.out.println(isNumeric("-1"));
        System.out.println(isNumeric("0"));
        System.out.println(isNumeric("-3.2"));
        System.out.println(isNumeric("3.2"));
        System.out.println(isNumeric("1.3456"));
        System.out.println(isNumeric("wqw12"));
    }

}
