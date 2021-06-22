package com.wq.xxx.utils.date;

import com.wq.xxx.utils.StringUtil;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jason on 2017/11/22.
 */
public class DateUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
    
    //可能出现的时间格式
    private static final String[] patterns = {
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd HH:mm",
            "yyyy/MM/dd HH:mm:ss",
            "yyyy/MM/dd HH:mm",
            "yyyy年MM月dd日",
            "yyyy-MM-dd",
            "yyyy/MM/dd",
            "yyyyMMdd"
    };
    
    /**
     * 格式化日期
     *
     * @param format 日期格式模板 yyyy-MM-dd yyyy/MM/dd
     * @param date   日期
     */
    public static String formatStr(String format, Date date) {
        if (null != date && !StringUtil.isNullOrEmpty(format)) {
            SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
            return simpleFormat.format(date);
        }
        return StringUtil.EMPTY;
    }
    
    /**
     * 格式化日期
     *
     * @param format 日期格式模板 yyyy-MM-dd yyyy/MM/dd
     * @param date   日期
     */
    public static Date formatDate(String format, Date date) throws ParseException {
        if (null != date && !StringUtil.isNullOrEmpty(format)) {
            SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
            String dateStr = simpleFormat.format(date);
            return simpleFormat.parse(dateStr);
        }
        return date;
    }
    
    /**
     * 格式化日期
     *
     * @param format  日期格式模板
     * @param strDate 日期
     */
    public static Date parse(String format, String strDate) throws ParseException {
        if (null != strDate && !StringUtil.isNullOrEmpty(format)) {
            SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
            return simpleFormat.parse(strDate);
        }
        return null;
    }
    
    /**
     * @param inputDate 要解析的字符串
     * @return 解析出来的日期，如果没有匹配的返回null
     */
    public static Date parseDate(String inputDate) {
        SimpleDateFormat df = new SimpleDateFormat();
        for (String pattern : patterns) {
            df.applyPattern(pattern);
            df.setLenient(false);//设置解析日期格式是否严格解析日期
            ParsePosition pos = new ParsePosition(0);
            Date date = df.parse(inputDate, pos);
            if (date != null) {
                return date;
            }
        }
        return null;
    }
    
    
    /**
     * 获取标准日期，忽略时间 yyyy-MM-dd
     *
     * @param date 原始日期
     * @return 处理后的日期
     */
    public static Date getNormalDate(Date date) throws ParseException {
        return formatDate(DatePattern.NORM_DATE_FORMAT, date);
    }
    
    /**
     * 获取标准日期，忽略时间 yyyy-MM-dd
     *
     * @param date 原始日期
     * @return 处理后的日期
     */
    public static Date getNormalDate(String date) throws ParseException {
        return parse(DatePattern.NORM_DATE_FORMAT, date);
    }
    
    /**
     * 转换字符串为标准日期+时间 yyyy-MM-dd HH:mm:ss
     *
     * @param date 原始日期
     * @return 处理后的日期
     */
    public static Date getNormalDateTime(String date) throws ParseException {
        return parse(DatePattern.NORM_DATETIME_FORMAT, date);
    }
    
    /**
     * 获取月份标识
     *
     * @param date 日期
     * @return 月份
     */
    public static Integer getDataMonthNumber(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }
    
    /**
     * 转换格式 yyyyMM
     *
     * @param date 日期
     * @return
     */
    public static Integer getSimpleMonth(Date date) {
        String month = formatStr(DatePattern.SIMPLE_MONTH_FORMAT, date);
        return Integer.parseInt(month);
    }
    
    /**
     * 转换格式 yyyyMMdd
     *
     * @param date 日期
     * @return
     */
    public static Integer getSimpleDate(Date date) {
        if (date == null) {
            return -1;
        }
        String month = formatStr(DatePattern.SIMPLE_DATE_FORMAT, date);
        return Integer.parseInt(month);
    }
    
    /**
     * 转换格式 yyyyMMdd
     *
     * @param date 日期
     * @return
     */
    public static Date getSimpleDate(Integer date, Date defaultDate) throws ParseException {
        if (date == null) {
            return defaultDate;
        }
        return parse(DatePattern.SIMPLE_DATE_FORMAT, String.valueOf(date));
    }
    
    /**
     * 转换格式 yyyyMM
     *
     * @param date
     * @param defaultDate
     * @return
     */
    public static Date getSimpleMonth(Integer date, Date defaultDate) throws ParseException {
        if (date == null) {
            return defaultDate;
        }
        return parse(DatePattern.SIMPLE_MONTH_FORMAT, String.valueOf(date));
    }
    
    
    /**
     * 格式转换 yyyyMMdd
     *
     * @param date 数字格式
     * @return 日期格式
     */
    public static Date getSimpleDate(Integer date) throws ParseException {
        return parse(DatePattern.SIMPLE_DATE_FORMAT, String.valueOf(date));
    }
    
    public static boolean timeMatch(Date startTime, Date endTime, Date targetStartTime, Date targetEndTime) {
        return (targetStartTime.compareTo(startTime) <= 0 && targetEndTime.compareTo(startTime) >= 0)
                || (targetStartTime.compareTo(endTime) <= 0 && targetEndTime.compareTo(endTime) >= 0)
                || (targetStartTime.compareTo(startTime) >= 0 && targetEndTime.compareTo(endTime) <= 0);
    }
    
    /**
     * 格式化日期(当前时间)
     *
     * @param format 日期格式模板
     */
    public static String formatNow(String format) {
        return formatStr(format, new Date());
    }
    
    /**
     * 获取日期之间天数差
     *
     * @param lessDate
     * @param bigDate
     * @return
     */
    public static Integer daysBetween(Date lessDate, Date bigDate) {
        if (null == lessDate || null == bigDate) {
            return 0;
        }
        Calendar cNow = Calendar.getInstance();
        Calendar cReturnDate = Calendar.getInstance();
        cNow.setTime(lessDate);
        cReturnDate.setTime(bigDate);
        setTimeToMidnight(cNow);
        setTimeToMidnight(cReturnDate);
        Long todayMs = cNow.getTimeInMillis();
        Long returnMs = cReturnDate.getTimeInMillis();
        long intervalMs = Math.abs(todayMs - returnMs);
        long days = (intervalMs / (1000 * 86400));
        return (int) days;
    }
    
    public static boolean sameDate(Date d1, Date d2) {
        LocalDate localDate1 = ZonedDateTime.ofInstant(d1.toInstant(), ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = ZonedDateTime.ofInstant(d2.toInstant(), ZoneId.systemDefault()).toLocalDate();
        return localDate1.isEqual(localDate2);
    }
    
    /**
     * 获取日期之间小时差
     *
     * @param lessDate
     * @param bigDate
     * @return
     */
    public static Double hourBetween(Date lessDate, Date bigDate) {
        if (null == lessDate || null == bigDate) {
            return 0D;
        }
        Calendar cNow = Calendar.getInstance();
        Calendar cReturnDate = Calendar.getInstance();
        cNow.setTime(lessDate);
        cReturnDate.setTime(bigDate);
        long todayMs = cNow.getTimeInMillis();
        long returnMs = cReturnDate.getTimeInMillis();
        long intervalMs = Math.abs(todayMs - returnMs);
        return intervalMs / (1000 * 3600.0);
    }
    
    private static void setTimeToMidnight(Calendar calendar) {
        changeTimeDetail(calendar, 0, 0);
    }
    
    /**
     * 获取给定日期所在的年
     *
     * @param dateTime 给定的日期
     * @return yyyy
     */
    public static int getYearByDate(Date dateTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        return cal.get(Calendar.YEAR);
    }
    
    /**
     * 获取昨天日期
     *
     * @return
     */
    public static Date getYesterday() {
        return getYesterday(null);
    }
    
    /**
     * 获取昨天日期
     *
     * @return
     */
    public static Date getYesterday(Date date) {
        Calendar cNow = Calendar.getInstance();
        //获取前一天
        cNow.setTime(date == null ? new Date() : date);
        cNow.add(Calendar.DAY_OF_MONTH, -1);
        return cNow.getTime();
    }
    
    public static Date addDay(Date date) {
        int amount = 1;
        return addDay(date, amount, Calendar.DAY_OF_MONTH);
    }
    
    public static Date addDay(Date date, int amount, int dayOfMonth) {
        Calendar cNow = Calendar.getInstance();
        cNow.setTime(date);
        cNow.add(dayOfMonth, amount);
        return cNow.getTime();
    }
    
    /**
     * 是否是月初第一天
     *
     * @param date 日期
     * @return
     */
    public static boolean monthStart(Date date) {
        Calendar cNow = Calendar.getInstance();
        cNow.setTime(date);
        int day = cNow.get(Calendar.DAY_OF_MONTH);
        int first = cNow.getMinimum(Calendar.DAY_OF_MONTH);
        return day == first;
    }
    
    /**
     * 获取今天结束
     *
     * @return 结束
     */
    public static String getCurrentDayEnd() {
        Calendar cNow = Calendar.getInstance();
        changeTimeDetail(cNow, 0, 0);
        return Long.toString(cNow.getTimeInMillis());
    }
    
    private static void changeTimeDetail(Calendar cNow, int dayHour, int minute) {
        cNow.set(Calendar.HOUR_OF_DAY, dayHour);
        cNow.set(Calendar.MINUTE, minute);
        cNow.set(Calendar.SECOND, minute);
        cNow.set(Calendar.MILLISECOND, 0);
    }
    
    public static Date changeTimeDetail(Date date, int dayHour, int minute) {
        Calendar cNow = Calendar.getInstance();
        cNow.setTime(date);
        changeTimeDetail(cNow, dayHour, minute);
        return cNow.getTime();
    }
    
    /**
     * 获取gps对接时间
     *
     * @param currentDate 数据日期
     * @param forEnd      是否获取结束时间（结束时间日期往后延一天）
     * @return gps对接时间
     */
    public static Date convertToGpsDockTime(Date currentDate, boolean forEnd) {
        Calendar cNow = Calendar.getInstance();
        cNow.setTime(currentDate);
        if (forEnd) {
            //如果是结束时间则时间跳转到次日
            cNow.add(Calendar.DAY_OF_MONTH, 1);
        }
        changeTimeDetail(cNow, 0, 0);
        return cNow.getTime();
    }
    
    /**
     * 获取月份最后一天
     *
     * @param reportMonth
     * @return
     */
    public static Date getEndOfMonth(Date reportMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(reportMonth);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        changeTimeDetail(calendar, 0, 0);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.SECOND, -1);
        return calendar.getTime();
    }
    
    /**
     * 获取月份第一天
     *
     * @param reportMonth
     * @return
     */
    public static Date getStartOfMonth(Date reportMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(reportMonth);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        changeTimeDetail(calendar, 0, 0);
        return calendar.getTime();
    }
    
    public static Date getStartOfYear(Date reportMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(reportMonth);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        changeTimeDetail(calendar, 0, 0);
        return calendar.getTime();
    }
    
    /**
     * 获取一天的开始时间
     *
     * @param date 日期
     * @return 当天的最后时间
     */
    public static Date getStartOfDay(Date date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DatePattern.NORM_DATE_FORMAT);
        String endStr = dateFormat.format(date) + " 00:00:00";
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endStr);
    }
    
    /**
     * 获取一天的结束时间
     *
     * @param date 日期
     * @return 当天的最后时间
     */
    public static Date getEndOfDay(Date date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DatePattern.NORM_DATE_FORMAT);
        String endStr = dateFormat.format(date) + " 23:59:59";
        return new SimpleDateFormat(DatePattern.NORM_DATETIME_FORMAT).parse(endStr);
    }
    
    public static boolean isTimeFormat(String timeSting) {
        String regExp = "([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
        return checkFormat(timeSting, regExp);
    }
    
    public static boolean isMonthFormat(String timeSting) {
        String regExp = "(?!0000)[0-9]{4}-((0[1-9]|1[0-2]))$";
        return checkFormat(timeSting, regExp);
    }
    
    public static boolean checkFormat(String timeSting, String regExp) {
        if (timeSting == null) {
            return false;
        }
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(timeSting);
        return m.matches();
    }
    
    /**
     * 时间加减
     *
     * @param date   时间
     * @param field  加减字段
     * @param amount 加减值
     * @return 处理后日期
     */
    public static Date timeAdd(Date date, int field, int amount) {
        return addDay(date, amount, field);
    }
    
    /**
     * 获取今天结束
     *
     * @return 结束
     */
    public static String getFileDataTag() {
        Calendar cNow = Calendar.getInstance();
        return formatStr(DatePattern.SIMPLE_DATETIME_MS_FORMAT, cNow.getTime());
    }
    
    //获取两个时间点最小的时间
    public static Date getLatestDate(Date firstDate, Date secondDate) {
        //无法比较返回null
        if (Objects.isNull(firstDate) || Objects.isNull(secondDate)) {
            return null;
        }
        return 0 > firstDate.compareTo(secondDate) ? firstDate : secondDate;
    }
    
    public static List<String> getYearMonthDayList(Date startTime, Date endTime, String formatted) {
        return getDateForMatList(startTime, endTime, formatted, calendar -> calendar.add(Calendar.DAY_OF_MONTH, 1));
    }
    
    /**
     * 获取一天所在月份的所有日期
     *
     * @param date
     * @return
     */
    public static List<String> getYearMonthDayList(Date date) {
        Date startOfDay = DateUtil.getStartOfMonth(date);
        Date endOfMonth = DateUtil.getEndOfMonth(date);
        return getYearMonthDayList(startOfDay, endOfMonth);
    }
    
    /**
     * 获取两个时间的日期列表 yyyy-MM-dd
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static List<String> getYearMonthDayList(Date startTime, Date endTime) {
        return getYearMonthDayList(startTime, endTime, DatePattern.NORM_DATE_FORMAT);
    }
    
    /**
     * 获取两个时间的年月列表 yyyyMM
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static List<String> calcYearMonthList(Date startTime, Date endTime) {
        return getDateForMatList(startTime, endTime, DatePattern.SIMPLE_MONTH_FORMAT,
                calendar -> calendar.add(Calendar.MONTH, 1));
    }
    
    /**
     * 获取两个时间的年列表 yyyy
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static List<String> calcYearList(Date startTime, Date endTime) {
        return getDateForMatList(startTime, endTime, DatePattern.YEAR_FORMAT, calendar -> calendar.add(Calendar.YEAR, 1));
    }
    
    public static List<String> getDateForMatList(Date startTime, Date endTime, String formatString,
                                                 Consumer<Calendar> nextConsumer) {
        List<String> dateList = new ArrayList<>();
        if (Objects.isNull(startTime) || Objects.isNull(endTime)) {
            return dateList;
        }
        Date calcStartTime;
        Date calcEndTime;
        if (startTime.compareTo(endTime) < 0) {
            calcStartTime = startTime;
            calcEndTime = endTime;
        } else {
            calcStartTime = endTime;
            calcEndTime = startTime;
        }
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(calcStartTime);
        calendarStart.set(Calendar.HOUR_OF_DAY, 0);
        calendarStart.set(Calendar.MINUTE, 0);
        calendarStart.set(Calendar.SECOND, 0);
        
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(calcEndTime);
        calendarEnd.set(Calendar.HOUR_OF_DAY, 23);
        calendarEnd.set(Calendar.MINUTE, 59);
        calendarEnd.set(Calendar.SECOND, 59);
        while (calendarStart.compareTo(calendarEnd) <= 0) {
            dateList.add(DateUtil.formatStr(formatString, calendarStart.getTime()));
            nextConsumer.accept(calendarStart);
        }
        return dateList;
    }
    
    /**
     * 比较两个日期，按天比较（不考虑时间）
     *
     * @param srcDate 源日期
     * @param desDate 目标日期
     * @return srcDate>desDate 1, srcDate==desDate 0 ,stcDate<DesDate -1
     */
    public static int compareDateByDay(Date srcDate, Date desDate) {
        if (srcDate == null) {
            if (desDate == null) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if (desDate == null) {
                return 1;
            } else {
                srcDate = changeTimeDetail(srcDate, 0, 0);
                desDate = changeTimeDetail(desDate, 0, 0);
                return DateUtils.isSameDay(srcDate, desDate) ? 0 : srcDate.compareTo(desDate);
            }
        }
    }
    
    public static boolean isInDateRange(Date checkDate, Date startDate, Date endDate) {
        if (Objects.isNull(checkDate)) {
            checkDate = new Date();
        }
        List<String> rangeDateList = getYearMonthDayList(startDate, endDate);
        return rangeDateList.contains(formatStr(DatePattern.NORM_DATE_FORMAT, checkDate));
    }
    
    /**
     * yyyyMMddHHmmssSSS
     *
     * @return {@link String}
     */
    public static String getSecondTimeStr() {
        return formatStr(DatePattern.SIMPLE_DATETIME_MS_FORMAT, new Date());
    }
}