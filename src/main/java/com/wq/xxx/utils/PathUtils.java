package com.wq.xxx.utils;

/*
 * @Author：wuqiang
 * @Time: 2021/1/27-16:32
 * @Description: TODO
 */
public abstract class PathUtils {
    private static final String SEPARATOR = System.getProperty("file.separator");
    
    private PathUtils() {
    }
    
    public static String combine(String... vars) {
        return combine(false, false, vars);
    }
    
    public static String combine(boolean preFix, boolean suffix, String... vars) {
        String combinePath = String.join(SEPARATOR, vars);
        
        if (preFix) {
            combinePath = SEPARATOR + combinePath;
        }
        
        if (suffix) {
            combinePath += SEPARATOR;
        }
        return combinePath;
    }
}