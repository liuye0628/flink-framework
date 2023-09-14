package com.atguigu.javase.d_api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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
        /**
         * JDK8后日期类:**********常用*********
         */
        LocalDate localDate = LocalDate.now();//now():根据当前时间创建对象
        System.out.println(localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDate localDate1 = LocalDate.of(2023, 9, 13);//of:静态方法,根据指定日期,时间创建对象
        System.out.println(localDate1);
        System.out.println(localDate1.getDayOfYear());//getDayOfYear/getDayOfMonth:获取年份天数(1-366)/获取年份天数(1-31)
        System.out.println(localDate1.plusDays(2));//plusDays:向当前对象添加几天
        System.out.println(localDate1.minusDays(2));//minusDays:向当前对象减少几天
        /**
         * 指定时区日期时间:ZonedDateTime
         */
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        ZonedDateTime zonedDateTime1= ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime1);
        /**
         * 持续日期/时间Period和Duration
         */
        LocalDate localDate2 = LocalDate.now();
        LocalDate localDate3 = LocalDate.of(2021, 9, 12);
        Period between = Period.between(localDate3, localDate2);//Period:用于计算两个日期间隔
        System.out.println(between);
        System.out.println("相差的年数："+between.getYears());
        System.out.println("相差的月数："+between.getMonths());
        System.out.println("相差的天数："+between.getDays());
        System.out.println("相差的总数："+between.toTotalMonths());

        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2019, 9, 12, 0, 0, 0, 0);
        Duration between1 = Duration.between(localDateTime2, localDateTime1);//Duration:用于计算两个时间 间隔
        System.out.println("相差的总天数："+between1.toDays());
        System.out.println("相差的总小时数："+between1.toHours());
        System.out.println("相差的总分钟数："+between1.toMinutes());
        System.out.println("相差的总秒数："+between1.getSeconds());
        System.out.println("相差的总毫秒数："+between1.toMillis());
        System.out.println("相差的总纳秒数："+between1.toNanos());
        System.out.println("不够一秒的纳秒数："+between1.getNano());
        /**
         * DateTimeFormatter:日期时间格式化
         */
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy.MM.dd");//创建格式化对象
        LocalDate parse = LocalDate.parse("2019.12.12", pattern);//解析操作
        System.out.println(parse);
        LocalDateTime localDateTime3 = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒 SSS毫秒 E 是这一年的D天");
        String format = df.format(localDateTime3);
        System.out.println(format);
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;//预定义的标准形式
        String format1 = isoDateTime.format(localDateTime3);
        System.out.println(format1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String format2 = dateTimeFormatter.format(localDateTime3);//本地化相关的形式
        System.out.println(format2);


    }

}
