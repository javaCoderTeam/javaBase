package com.chen.util;

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
     * @param str
     * @return
     */
    public static Boolean checkNum(String str) {

        return !isEmpty(str) && str.matches("^\\d+$");
    }

}
