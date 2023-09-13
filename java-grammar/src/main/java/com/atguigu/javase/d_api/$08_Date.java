package com.atguigu.javase.d_api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

//日期时间API
public class $08_Date {
    public static void main(String[] args) throws ParseException {
        /**
         * java.util.Date
         */
         Date date = new Date();
        System.out.println(date);//Wed Sep 13 20:10:42 CST 2023
        System.out.println(date.getTime());//1694607080010
        System.out.println(System.currentTimeMillis());//1694607157115(打印系统当前时间)
        /**
         * java.util.Calendar:抽象类,为特定时间如"Year","Month","Hour"等日历字段之间的转换提供了一些方法
         */
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);//java.util.GregorianCalendar[time=1694607403446,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2023,MONTH=8,WEEK_OF_YEAR=37,WEEK_OF_MONTH=3,DAY_OF_MONTH=13,DAY_OF_YEAR=256,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=8,HOUR_OF_DAY=20,MINUTE=16,SECOND=43,MILLISECOND=446,ZONE_OFFSET=28800000,DST_OFFSET=0]
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
        int month = calendar.get(Calendar.MONTH)+1;//月份从0开始,需要加一
        System.out.println(month);
        TimeZone t = TimeZone.getTimeZone("America/Los_Angeles");
        Calendar c1 = Calendar.getInstance(t);
        System.out.println(c1);
        /**
         * java.text.SimpleDateFormat:用于对日期时间的格式化
         */
        Date date1 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String str = sf.format(date1);
        System.out.println(str);
        String str1="2023年09月13日 20时28分25秒";
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyy年MM月dd日");
        Date date2 = sf1.parse(str1);
        System.out.println(date2);


    }

}
