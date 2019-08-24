package com.smart.report.commons.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/** 获取时间间隔工具方法
 * created by wuqiang on 2019/8/7
 */
public final class TimeIntervalTool
{

    // 每月/每周 第一天的日期格式
    public static final SimpleDateFormat DATE_FORMAT_START = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

    // 每月/每周 最后一天的日期格式
    public static final SimpleDateFormat DATE_FORMAT_END = new SimpleDateFormat("yyyy-MM-dd 23:59:59");

    private TimeIntervalTool()
    {

    }

    /**
     * @Param minDate 最远的
     *  根据当前日期获得所在周的日期区间（周一和周日日期） 
     */
    public static String getCurWeekTimeInterval(Date date, Date minDate)
    {
        return getCurWeekTimeInterval(date, minDate, DATE_FORMAT_START, DATE_FORMAT_END);
    }

    /**
     *  
     *  根据当前日期获得所在周的日期区间（周一和周日日期） 
     */
    public static String getCurWeekTimeInterval(Date date, Date minDate,
            SimpleDateFormat startFormat, SimpleDateFormat endFormat)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
        if (1 == dayWeek)
        {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值  
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);

        String imptimeBegin = "";
        boolean isOver = (minDate != null) && (minDate.getTime() > cal.getTime().getTime());
        if (isOver)
        {
            imptimeBegin = startFormat.format(minDate.getTime());
        }
        else
        {
            imptimeBegin = startFormat.format(cal.getTime());
        }

        cal.add(Calendar.DATE, 6);
        String imptimeEnd = endFormat.format(cal.getTime());
        return imptimeBegin + "," + imptimeEnd;
    }

    /**
     *  
     *  根据当前日期获得上周的日期区间（上周周一和周日日期） 
     */
    public static String getLastWeekTimeInterval(Date date)
    {
        return getLastWeekTimeInterval(date, DATE_FORMAT_START, DATE_FORMAT_END);
    }

    /**
     *  
     *  根据当前日期获得上周的日期区间（上周周一和周日日期） 
     */
    public static String getLastWeekTimeInterval(Date date, SimpleDateFormat startFormat, SimpleDateFormat endFormat)
    {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar2.setTime(date);
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek <= 0)
        {
            dayOfWeek = 7;
        }
        int offset1 = 1 - dayOfWeek;
        int offset2 = 7 - dayOfWeek;
        calendar1.add(Calendar.DATE, offset1 - 7);
        calendar2.add(Calendar.DATE, offset2 - 7);
        // last Monday
        String lastBeginDate = startFormat.format(calendar1.getTime());
        // last Sunday  
        String lastEndDate = endFormat.format(calendar2.getTime());
        return lastBeginDate + "," + lastEndDate;
    }

    // 获取本月的起始,结束时间
    public static String getCurMonthInterval(Date date)
    {
        return getCurMonthInterval(date, DATE_FORMAT_START, DATE_FORMAT_END);
    }

    // 获取本月的起始,结束时间
    public static String getCurMonthInterval(Date curDate, SimpleDateFormat startFormat, SimpleDateFormat endFormat)
    {
        Calendar ca = Calendar.getInstance();
        ca.setTime(curDate);

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

        int maximum = ca.getActualMaximum(Calendar.DAY_OF_MONTH);

        int minmum = ca.getActualMinimum(Calendar.DAY_OF_MONTH);

        int day = ca.get(Calendar.DAY_OF_MONTH);

        Calendar cal = (Calendar) ca.clone();

        cal.add(Calendar.DATE, maximum - day);

        Date dateD = cal.getTime();

        String strD = startFormat.format(dateD);

        cal = (Calendar) ca.clone();

        cal.add(Calendar.DATE, minmum - day);

        Date dateX = cal.getTime();

        String strX = endFormat.format(dateX);

        return strD + "," + strX;
    }

    /**
     * 将两个日期按周分组
     * @param dateStart 开始
     * @param dateEnd 结束
     * @param minDate 不得早于此日期
     * @return
     */
    public static Map<String, String> getWeeks(Date dateStart, Date dateEnd, Date minDate)
    {
        int dateCount = daysBetweenTwoTime(dateStart, dateEnd);
        if (dateCount < 0)
        {
            return new HashMap<>();
        }

        Map<String, String> weekResult = new HashMap<String, String>();

        int weeks = Math.round(dateCount / 7 + 0.5f);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateStart);
        for (int i = 0; i < weeks; i++)
        {
            String curWeekTimeInterval = TimeIntervalTool.getCurWeekTimeInterval(dateStart, minDate);
            String month = String.format("2019%02d", Calendar.WEEK_OF_YEAR);
            calendar.add(Calendar.DATE, 7);
            dateStart = calendar.getTime();
            weekResult.put(month, curWeekTimeInterval);
        }

        return weekResult;
    }

    private static int daysBetweenTwoTime(Date startDate, Date endDate)
    {
        if (startDate != null && endDate != null)
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(endDate);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            return between_days < 0 ? -1 : Integer.parseInt(String.valueOf(between_days));
        }
        return -1;
    }
}
