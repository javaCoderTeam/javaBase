package com.chen.api.util.base;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Chen Weijie on 2017/8/6.
 */
public class DateTest {

    @Test
    public void testDate() {
        Date date = new Date(1000000000);
        System.out.println("date:" + date);
    }

    @Test
    public void testCalendar(){
        Calendar calendar =Calendar.getInstance();
        System.out.println("calendar:"+calendar);
        System.out.println("timeMillions:"+calendar.getTimeInMillis());


    }


}
