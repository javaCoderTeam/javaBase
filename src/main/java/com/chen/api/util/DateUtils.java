package com.chen.api.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author :  chen weijie
 * @Date: 2019-05-16 14:46
 */
public class DateUtils {


    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        //    1.Calendar 转化 String

        Calendar calendat = Calendar.getInstance();


        String dateStr = sdf.format(calendat.getTime());


//        2.String 转化Calendar

        String str = "2012-5-27";
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);


//        3.Date 转化String


        dateStr = sdf.format(new Date());


//        4.String 转化Date

        str = "2012-5-27";


        date = sdf.parse(str);


//        5.Date 转化Calendar

        calendar = Calendar.getInstance();

        calendar.setTime(new java.util.Date());


//        6.Calendar转化Date

        calendar = Calendar.getInstance();

        date = calendar.getTime();


//        7.String 转成 Timestamp

        Timestamp ts = Timestamp.valueOf("2012-1-14 08:11:00");


//        8.Date 转 TimeStamp

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String time = df.format(new Date());

        ts = Timestamp.valueOf(time);


    }


}
