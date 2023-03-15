package com.mslk.common.util;

import static java.lang.System.out;

public class DayUtil {

    public static String MinuteTODay(String inputnum){
        Long num = Long.parseLong(inputnum);

        //시, 분, 초 선언

        Long day, hours, minute, second;

        //시간공식

        day = num / 60 / 24 % 365;
        hours = num / 60 % 24;
        minute = num % 60;

        return Long.toString(day).toString().substring(0,1) + "일 " +Long.toString(hours).toString().substring(0,1) + "시간 " + Long.toString(minute).toString().substring(0,1) + "분";

    }


}
