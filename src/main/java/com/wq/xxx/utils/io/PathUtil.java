package com.wq.xxx.utils.io;

/*
 * @Author：wuqiang
 * @Time: 2021/1/27
 * @Description: 文件路径工具
 */
public abstract class PathUtil {
    private static final String SEPARATOR = System.getProperty("file.separator");
    
    private PathUtil() {
    }
    
    /**
     * 路径拼接
     *
     * @param vars var
     * @return {@link String}
     */
    public static String combine(String... vars) {
        return combine(false, false, vars);
    }
    
    /**
     * 路径拼接
     *
     * @param preFix 是否需要前缀
     * @param suffix 是否需要后缀
     * @param vars   路径变量数组
     * @return {@link String}
     */
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