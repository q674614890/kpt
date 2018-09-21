package com.pri.yunshuwanli.cloudticket.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String FORMATE = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMATE2 = "yyyy-MM-dd";

    public static  String getTodayDate2(){
        SimpleDateFormat sdf = new SimpleDateFormat(FORMATE2);
        String date = sdf.format(new Date());
        return date;
    }
    public static  String getTodayDate(){
        SimpleDateFormat sdf = new SimpleDateFormat(FORMATE);
        String date = sdf.format(new Date());
        return date;
    }
    public static String getYestoryDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        SimpleDateFormat sdf = new SimpleDateFormat(FORMATE);
        String yestoday = sdf.format(calendar.getTime());
        return yestoday;
    }

    public static String getDate(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-day);
        SimpleDateFormat sdf = new SimpleDateFormat(FORMATE);
        String dayS = sdf.format(calendar.getTime());
        return dayS;
    }
}