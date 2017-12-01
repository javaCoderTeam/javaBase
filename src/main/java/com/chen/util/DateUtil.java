package com.chen.util;

import java.time.format.DateTimeFormatter;

/**
 * JDK8新的日期API实现的日期工具类.
 * Created by chenwj3 on 2017/1/18.
 */
public class DateUtil {

    public static final String DATE_8 = "yyyyMMdd";
    public static final DateTimeFormatter DATE_TIME_FORMATTER_8 = DateTimeFormatter.ofPattern(DATE_8);
    public static final String DATE_10 = "yyyy-MM-dd";
    public static final DateTimeFormatter DATE_TIME_FORMATTER_10 = DateTimeFormatter.ofPattern(DATE_10);
    public static final String DATETIME_19 = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter DATE_TIME_FORMATTER_19 = DateTimeFormatter.ofPattern(DATETIME_19);
    public static final String DATETIME_17 = "yyyyMMdd HH:mm:ss";
    public static final DateTimeFormatter DATE_TIME_FORMATTER_17 = DateTimeFormatter.ofPattern(DATETIME_17);
    public static final String DATETIME_14 = "yyyyMMddHHmmss";
    public static final DateTimeFormatter DATE_TIME_FORMATTER_14 = DateTimeFormatter.ofPattern(DATETIME_14);
}
