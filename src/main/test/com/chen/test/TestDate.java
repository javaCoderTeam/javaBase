package com.chen.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author :  chen weijie
 * @Date: 2019-06-28 11:45
 */
public class TestDate {


    public static void main(String[] args) {


        Date date = stringToDate("HH:mm:ss", "06:00:00");
        Long score = date.getTime();



        System.out.println("socre==="+score);





    }



    public static Date stringToDate(String format, String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (Exception e) {
            String msg = String.format("格式化%s失败！", date);
            throw new RuntimeException(msg);
        }
    }


}
