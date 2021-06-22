package com.wq.xxx.utils;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jason on 2017/11/22.
 */
public class StringUtil {
    /**
     * 空字符串
     */
    public static final String EMPTY = "";
    
    /**
     * 拼接成模糊搜索字符串
     *
     * @param value 原始字符串
     */
    public static String buildFuzzyMatchString(String value) {
        return "%" + value + "%";
    }
    
    /**
     * 拼接成模糊搜索字符串
     *
     * @param value 原始字符串
     */
    public static String buildLeftFuzzyMatchString(String value) {
        return value + "%";
    }
    
    /**
     * 拼接成模糊搜索字符串
     *
     * @param value 原始字符串
     */
    public static String buildRightFuzzyMatchString(String value) {
        return "%" + value;
    }
    
    /**
     * 按位数补齐整数前的0，
     *
     * @param number 整数
     * @param length 整数长度
     * @return 字符串
     */
    public static String padLeftNumber(int number, int length) {
        String format = "%0" + length + "d";
        return String.format(format, number);
    }
    
    /**
     * 判断字符串是否为null或者空字符串
     *
     * @param s 字符串
     */
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }
    
    public static boolean isNotNullOrEmpty(String s) {
        return !isNullOrEmpty(s);
    }
    
    public static String multiplyStr(String a, String b) {
        if (isNullOrEmpty(a) || isNullOrEmpty(b)) {
            return null;
        }
        Double aa = Double.parseDouble(a);
        Double bb = Double.parseDouble(b);
        
        Double result = aa * bb;
        
        return String.format("%.4f", result);
    }
    
    public static String divideStr(String a, String b) {
        if (isNullOrEmpty(a) || isNullOrEmpty(b)) {
            return null;
        }
        Double aa = Double.parseDouble(a);
        Double bb = Double.parseDouble(b);
        
        Double result = aa / bb;
        
        return String.format("%.4f", result);
    }
    
    /**
     * 判断字符串是否为null或者白空格
     *
     * @param s 字符串
     */
    public static boolean isNullOrWhitespace(String s) {
        return s == null || isWhitespace(s);
    }
    
    /**
     * 判断字符串是否是白空格
     */
    private static boolean isWhitespace(String s) {
        int length = s.length();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    /**
     * 检测是否为数字
     *
     * @param str 字符串
     * @return 是或否
     */
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }
    
    public static String getShortString(String string, int count) {
        if (StringUtils.isEmpty(string)) {
            return EMPTY;
        }
        if (string.length() <= count) {
            return string;
        }
        return string.substring(0, count);
    }
    
    /**
     * 字符串转ASCII值
     *
     * @param str
     * @param separator 分隔符
     * @return
     */
    public static String getASCIIString(String str, String separator) {
        StringBuilder result = new StringBuilder();
        if (StringUtils.isEmpty(str)) {
            return result.toString();
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            if (!StringUtils.isEmpty(separator) && i > 0) {
                result.append(separator);
            }
            result.append((int) chars[i]);
        }
        return result.toString();
    }
}