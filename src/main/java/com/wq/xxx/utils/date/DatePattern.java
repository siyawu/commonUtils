package com.wq.xxx.utils.date;

import java.util.regex.Pattern;

/**
 * 常用日期格式
 * Created by wuqiang on 2021/5/13-10:20
 */
public final class DatePattern {
    private DatePattern() {
    }
    
    /**
     * 标准日期时间正则，每个字段支持单个数字或2个数字，包括：
     *     yyyy-MM-dd HH:mm:ss.SSS
     *     yyyy-MM-dd HH:mm:ss
     *     yyyy-MM-dd HH:mm
     *     yyyy-MM-dd
     */
    public static final Pattern REGEX_NORM = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}(\\s\\d{1,2}:\\d{1,2}(:\\d{1,2})?)?(.\\d{1,3})?");
    
    /**
     * 年月格式：yyyy-MM
     */
    public static final String YEAR_FORMAT = "yyyy";
    
    /**
     * 年月格式：yyyy-MM
     */
    public static final String NORM_MONTH_FORMAT = "yyyy-MM";
    
    /**
     * 简单年月格式：yyyyMM
     */
    public static final String SIMPLE_MONTH_FORMAT = "yyyyMM";
    
    /**
     * 标准日期格式：yyyy-MM-dd
     */
    public static final String NORM_DATE_FORMAT = "yyyy-MM-dd";
    
    /**
     * 简单日期格式：yyyyMMdd
     */
    public static final String SIMPLE_DATE_FORMAT = "yyyyMMdd";
    
    /**
     * 标准时间格式：HH:mm:ss
     */
    public static final String NORM_TIME_FORMAT = "HH:mm:ss";
    
    /**
     * 简单时间格式：HHmmss
     */
    public static final String SIMPLE_TIME_FORMAT = "HHmmss";
    
    /**
     * 标准日期时间格式，精确到分：yyyy-MM-dd HH:mm
     */
    public static final String NORM_DATETIME_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";
    
    
    /**
     * 简单日期时间格式，精确到分：yyyy-MM-dd HH:mm
     */
    public static final String SIMPLE_DATETIME_MINUTE_FORMAT = "yyyyMMddHHmm";
    
    /**
     * 标准日期时间格式，精确到秒：yyyy-MM-dd HH:mm:ss
     */
    public static final String NORM_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    /**
     * 标准日期时间格式，精确到分：yyyy/MM/dd HH:mm
     */
    public static final String NORM_BIAS_DATETIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
    
    /**
     * 简单日期时间格式：yyyyMMddHHmmss
     */
    public static final String SIMPLE_DATETIME_FORMAT = "yyyyMMddHHmmss";
    
    /**
     * 标准日期时间格式，精确到毫秒：yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String NORM_DATETIME_MS_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    
    /**
     * 简单日期时间格式，精确到毫秒：yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String SIMPLE_DATETIME_MS_FORMAT = "yyyyMMddHHmmssSSS";
    
    /**
     * 标准日期格式：yyyy年MM月dd日
     */
    public static final String CHINESE_DATE_FORMAT = "yyyy年MM月dd日";
    
    /**
     * 标准日期格式：yyyy年MM月dd日 HH时mm分ss秒
     */
    public static final String CHINESE_DATETIME_FORMAT = "yyyy年MM月dd日HH时mm分ss秒";
}
